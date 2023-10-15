package org.erlandhu.almall.coupon.service;

import lombok.RequiredArgsConstructor;
import org.erlandhu.almall.coupon.entity.CouponTemplate;
import org.erlandhu.almall.coupon.mapper.CouponTemplateMapper;
import org.springframework.stereotype.Service;

/**
 * @author huaolan created on 2023/10/15
 */

@Service
@RequiredArgsConstructor
public class CouponTemplateServiceImpl implements CouponTemplateService {

    private final CouponTemplateMapper couponTemplateMapper;

    @Override
    public CouponTemplate getOne(Integer id) {

        return couponTemplateMapper.getOne(id);
    }
}
