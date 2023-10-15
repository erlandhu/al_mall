package org.erlandhu.almall.coupon;

import lombok.RequiredArgsConstructor;
import org.erlandhu.almall.coupon.entity.CouponTemplate;
import org.erlandhu.almall.coupon.mapper.CouponTemplateMapper;
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
    public String t1() {
        CouponTemplate one = couponTemplateMapper.getOne(1);
        return one.getCouponName();
    }

}
