package org.erlandhu.almall.coupon.repository.mapper;

import org.apache.ibatis.annotations.Param;
import org.erlandhu.almall.coupon.repository.entity.CouponTemplate;

/**
 * @author huaolan created on 2023/09/15
 */
public interface CouponTemplateMapper {

    CouponTemplate getOne(@Param("id") Integer id);

    int decrementInventory(@Param("id") Integer id);

}
