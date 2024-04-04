package org.erlandhu.almall.coupon.service;

import lombok.RequiredArgsConstructor;
import org.erlandhu.almall.coupon.api.CouponProvider;
import org.erlandhu.almall.coupon.api.dto.ApplyCouponRequest;
import org.erlandhu.almall.coupon.repository.entity.Coupon;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author huaolan created on 2024/04/04
 */


@Service
@RequiredArgsConstructor
@Repository
public class CouponProviderImpl implements CouponProvider {

    private CouponService couponService;

    @Override
    public Coupon applyCoupon(ApplyCouponRequest request) {
        return couponService.applyCoupon(request);
    }
}
