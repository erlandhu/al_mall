package org.erlandhu.almall.coupon.controller;

import lombok.RequiredArgsConstructor;
import org.erlandhu.almall.coupon.api.dto.ApplyCouponRequest;
import org.erlandhu.almall.coupon.repository.entity.Coupon;
import org.erlandhu.almall.coupon.repository.entity.CouponTemplate;
import org.erlandhu.almall.coupon.repository.mapper.CouponTemplateMapper;
import org.erlandhu.almall.coupon.service.CouponService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huaolan created on 2023/10/15
 */

@RestController
@RequestMapping("test")
@RequiredArgsConstructor
public class TestController {

    private final CouponTemplateMapper couponTemplateMapper;
    private final CouponService couponService;



    @GetMapping("couponTemplate")
    public CouponTemplate t1(int param) {
        ApplyCouponRequest applyCouponRequest = new ApplyCouponRequest();
        applyCouponRequest.setCouponTemplateId(param);
        applyCouponRequest.setMemberId(1);

        Coupon coupon = couponService.applyCoupon(applyCouponRequest);

        CouponTemplate one = couponTemplateMapper.getOne(1);
        return one;
    }

}
