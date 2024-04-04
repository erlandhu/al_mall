package org.erlandhu.almall.coupon.repository.service;

import lombok.RequiredArgsConstructor;
import org.erlandhu.almall.coupon.repository.mapper.CouponMapper;
import org.springframework.stereotype.Service;

/**
 * @author huaolan created on 2024/04/04
 */

@Service
@RequiredArgsConstructor
public class ICouponServiceImpl implements ICouponService {

    private final CouponMapper couponMapper;

}
