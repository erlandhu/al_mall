package org.erlandhu.almall.coupon.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.erlandhu.almall.coupon.api.dto.ApplyCouponRequest;
import org.erlandhu.almall.coupon.repository.entity.Coupon;
import org.erlandhu.almall.coupon.repository.service.ICouponService;
import org.erlandhu.almall.coupon.repository.service.ICouponTemplateService;
import org.erlandhu.almall.coupon.repository.service.ISimplePromotionService;
import org.springframework.stereotype.Service;

/**
 * @author huaolan created on 2024/04/04
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class CouponService {

    private final ICouponService couponService;
    private final ICouponTemplateService couponTemplateService;
    private final ISimplePromotionService simplePromotionService;

    /**
     * 领取优惠券
     */
    public Coupon applyCoupon(ApplyCouponRequest request) {



        return null;
    }
}
