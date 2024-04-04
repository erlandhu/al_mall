package org.erlandhu.almall.coupon;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.erlandhu.almall.coupon.repository.entity.CouponTemplate;
import org.erlandhu.almall.coupon.repository.service.ICouponTemplateService;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author huaolan created on 2024/04/04
 */


@Slf4j
@Component
@RequiredArgsConstructor
public class InventoryManager {

    private final RedissonClient redissonClient;
    private final ICouponTemplateService couponTemplateService;


    public boolean decrease(Integer couponTemplateId) {
        return decrease(couponTemplateId, 1);
    }

    public boolean decrease(Integer couponTemplateId, int i) {
        Assert.notNull(couponTemplateId, "无效的合同ID");

        String inventoryKey = String.format(Contst.COUPON_INVENTORY_KEY, couponTemplateId);
        RAtomicLong atomicLong = redissonClient.getAtomicLong(inventoryKey);
        boolean exists = atomicLong.isExists();
        if (!exists) {
            loadInventoryFromDB(couponTemplateId, inventoryKey);
        }
        long newInventory = atomicLong.decrementAndGet();
        return newInventory >= 0;
    }

    private void loadInventoryFromDB(Integer couponTemplateId, String queryInventoryKey) {
        CouponTemplate couponTemplate = couponTemplateService.getOne(couponTemplateId);
        RBucket<Integer> bucket = redissonClient.getBucket(queryInventoryKey);
        Integer inventory = couponTemplate.getInventory();
        boolean loadInventorySuccess = bucket.trySet(inventory);
        if (loadInventorySuccess) {
            log.info("从数据库加载库存成功:{}", couponTemplateId);
        }
    }


}
