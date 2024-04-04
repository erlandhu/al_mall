package org.erlandhu.almall.coupon.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.erlandhu.almall.coupon.repository.entity.CouponTemplate;
import org.erlandhu.almall.coupon.repository.service.ICouponTemplateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huaolan created on 2023/10/15
 */

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("couponTemplate")
public class CouponTemplateController {

    private final ICouponTemplateService ICouponTemplateService;

    @GetMapping
    public CouponTemplate getOne(Integer id) {
        return ICouponTemplateService.getOne(id);
    }
}
