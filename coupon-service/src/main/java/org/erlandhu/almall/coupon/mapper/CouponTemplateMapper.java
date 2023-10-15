package org.erlandhu.almall.coupon.mapper;

import org.apache.ibatis.annotations.Param;
import org.erlandhu.almall.coupon.entity.CouponTemplate;

/**
 * @author huaolan created on 2023/09/15
 */
public interface CouponTemplateMapper {

    CouponTemplate getOne(@Param("id") Integer id);

}
