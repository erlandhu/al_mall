package org.erlandhu.almall.coupon.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.erlandhu.almall.coupon.InventoryManager;
import org.erlandhu.almall.coupon.api.dto.ApplyCouponRequest;
import org.erlandhu.almall.coupon.repository.entity.Coupon;
import org.erlandhu.almall.coupon.repository.entity.CouponTemplate;
import org.erlandhu.almall.coupon.repository.entity.CouponTemplateState;
import org.erlandhu.almall.coupon.repository.service.ICouponService;
import org.erlandhu.almall.coupon.repository.service.ICouponTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.Instant;

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
        Coupon coupon = generate(couponTemplate);


        // 库存入库、生成领取记录
        int i = couponTemplateService.decrementInventory(couponTemplateId);

        return coupon;
    }

    private Coupon generate(CouponTemplate couponTemplate) {
        Coupon coupon = new Coupon();
        return coupon;
    }
}
