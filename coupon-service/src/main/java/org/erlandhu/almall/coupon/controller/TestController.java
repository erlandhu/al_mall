package org.erlandhu.almall.coupon.controller;

import lombok.RequiredArgsConstructor;
import org.erlandhu.almall.coupon.repository.entity.CouponTemplate;
import org.erlandhu.almall.coupon.repository.mapper.CouponTemplateMapper;
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


    @GetMapping("couponTemplate")
    public CouponTemplate t1() {
        CouponTemplate one = couponTemplateMapper.getOne(1);
        return one;
    }

}
