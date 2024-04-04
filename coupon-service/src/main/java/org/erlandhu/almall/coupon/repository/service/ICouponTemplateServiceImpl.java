package org.erlandhu.almall.coupon.repository.service;

import lombok.RequiredArgsConstructor;
import org.erlandhu.almall.coupon.repository.entity.CouponTemplate;
import org.erlandhu.almall.coupon.repository.mapper.CouponTemplateMapper;
import org.springframework.stereotype.Service;

/**
 * @author huaolan created on 2023/10/15
 */

@Service
@RequiredArgsConstructor
public class ICouponTemplateServiceImpl implements ICouponTemplateService {

    private final CouponTemplateMapper couponTemplateMapper;

    @Override
    public CouponTemplate getOne(Integer id) {

        return couponTemplateMapper.getOne(id);
    }
}
