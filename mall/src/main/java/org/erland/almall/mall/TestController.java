package org.erland.almall.mall;

import org.erland.almall.mall.coupon.remote.CouponTemplateService;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author huaolan created on 2023/09/02
 */

@RestController
@RequestMapping("test")
public class TestController {

    private final CouponTemplateService couponTemplateService;
    private final DiscoveryClient discoveryClient;
    private final RestTemplate restTemplate;

    @GetMapping
    public Object getCouponTemplate(Integer id) {
        return couponTemplateService.getOne(id);
    }

    @GetMapping("services/{service}")
    public Object test(@PathVariable String service) {
        return discoveryClient.getInstances(service);
    }


    public TestController(CouponTemplateService couponTemplateService, DiscoveryClient discoveryClient, RestTemplate restTemplate) {
        this.couponTemplateService = couponTemplateService;
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
    }
}
