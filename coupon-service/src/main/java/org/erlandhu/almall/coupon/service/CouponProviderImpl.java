package org.erlandhu.almall.coupon.service;

import lombok.RequiredArgsConstructor;
import org.erlandhu.almall.coupon.api.CouponProvider;
import org.erlandhu.almall.coupon.api.dto.ApplyCouponRequest;
import org.erlandhu.almall.coupon.repository.entity.Coupon;
import org.springframework.stereotype.Service;

/**
 * @author huaolan created on 2024/04/04
 */


@Service
@RequiredArgsConstructor
public class CouponProviderImpl implements CouponProvider {

    private final CouponService couponService;

    @Override
    public Coupon applyCoupon(ApplyCouponRequest request) {
        return couponService.applyCoupon(request);
    }
}
