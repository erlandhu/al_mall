package org.erlandhu.almall.coupon.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.erlandhu.almall.coupon.InventoryManager;
import org.erlandhu.almall.coupon.api.dto.ApplyCouponRequest;
import org.erlandhu.almall.coupon.repository.entity.Coupon;
import org.erlandhu.almall.coupon.repository.entity.CouponTemplate;
import org.erlandhu.almall.coupon.repository.entity.CouponTemplateState;
import org.erlandhu.almall.coupon.repository.entity.CouponType;
import org.erlandhu.almall.coupon.repository.service.ICouponService;
import org.erlandhu.almall.coupon.repository.service.ICouponTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;

import static java.math.RoundingMode.DOWN;

/**
 * @author huaolan created on 2024/04/04
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class CouponService {

    private final ICouponService couponService;
    private final InventoryManager inventoryManager;
    private final ICouponTemplateService couponTemplateService;

    /**
     * 领取优惠券
     */
    @Transactional
    public Coupon applyCoupon(ApplyCouponRequest request) {
        int memberId = request.getMemberId();
        Assert.isTrue(memberId > 0, "用户ID无效");

        int couponTemplateId = request.getCouponTemplateId();
        CouponTemplate couponTemplate = couponTemplateService.getOne(couponTemplateId);
        Assert.notNull(couponTemplate, "合同模板ID无效");

        // 优惠券状态
        Integer couponState = couponTemplate.getCouponState();
        boolean available = CouponTemplateState.isAvailable(couponState);
        Assert.isTrue(available, "该优惠券无效");

        Instant now = Instant.now();
        if (now.isBefore(couponTemplate.getStartTime()) || now.isAfter(couponTemplate.getEndTime())) {
            log.warn("当前时间不可领取");
            throw new IllegalArgumentException("当前时间不可领取");
        }

        // redis 库存
        boolean decreaseSuccess = inventoryManager.decrease(couponTemplateId);
        if (!decreaseSuccess) {
            log.warn("领券失败，库存不足 couponTemplateId:{}", couponTemplateId);
            throw new RuntimeException("领券失败，库存不足");
        }

        // 生成优惠券
        Coupon coupon = generate(couponTemplate, memberId);

        // 库存入库、生成领取记录
        int i = couponTemplateService.decrementInventory(couponTemplateId, coupon.getDiscountAmount().doubleValue());

        return coupon;
    }

    private Coupon generate(CouponTemplate couponTemplate, Integer memberId) {
        Coupon coupon = new Coupon();
        coupon.setCouponCode(System.nanoTime()+"");
        coupon.setCouponType(CouponType.CASH_COUPON.ordinal());
        coupon.setShopId(couponTemplate.getShopId());
        coupon.setMemberId(memberId);
        coupon.setCouponTemplateId(couponTemplate.getId());
        coupon.setMemberName("");
        coupon.setMemberPhone("");
        coupon.setDiscountAmount(discount(couponTemplate.getInventory(), couponTemplate.getBalance()));
        coupon.setStartTime(Instant.now());
        coupon.setEndTime(Instant.now().plus(1, ChronoUnit.YEARS));

        return coupon;
    }


    public static BigDecimal discount(int totalInventory, BigDecimal totalAmount) {
        if (totalInventory == 1) {
            return totalAmount;
        }

        BigDecimal preAmount = totalAmount.divide(new BigDecimal(totalInventory), 2, DOWN);

        double minAmount = 0.01;
        double maxAmount = preAmount.multiply(new BigDecimal(2)).doubleValue();

        ThreadLocalRandom current = ThreadLocalRandom.current();

        double v = current.nextDouble(minAmount, maxAmount);
        BigDecimal bigDecimal = new BigDecimal("" + v);
        return bigDecimal.setScale(2, DOWN);
    }

    public static void main(String[] args) {

        BigDecimal totalAmount = new BigDecimal(100);
        int totalInventory = 10;

        BigDecimal afterTotal = BigDecimal.ZERO;
        int index = 1;

        for (; totalInventory > 0; totalInventory--) {
            BigDecimal discount = discount(totalInventory, totalAmount);
            System.err.println("第" + index + "个包金额：" + discount);

            totalAmount = totalAmount.subtract(discount);

            System.out.println("剩余金额：" + totalAmount);

            afterTotal = afterTotal.add(discount);

            index++;
        }

        System.err.println("over");
        System.err.println("afterTotal" + afterTotal);

    }
}
