package org.erlandhu.almall.coupon.repository.mapper;

import org.apache.ibatis.annotations.Param;
import org.erlandhu.almall.coupon.repository.entity.Coupon;

/**
 * @author huaolan created on 2023/09/15
 */
public interface CouponMapper {

    Coupon getOne(@Param("id") Integer id);

}
