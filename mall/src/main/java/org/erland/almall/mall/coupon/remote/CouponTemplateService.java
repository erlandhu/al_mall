package org.erland.almall.mall.coupon.remote;

import feign.Request;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huaolan created on 2023/10/15
 */

@Component
@FeignClient(name = "coupon-service", path = "/coupon-service")
public interface CouponTemplateService {

    @GetMapping(value = "couponTemplate")
    Object getOne(@RequestParam Integer id);



}
