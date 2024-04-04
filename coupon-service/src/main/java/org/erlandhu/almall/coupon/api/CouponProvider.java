package org.erlandhu.almall.coupon.api;

import org.erlandhu.almall.coupon.api.dto.ApplyCouponRequest;
import org.erlandhu.almall.coupon.repository.entity.Coupon;

/**
 * @author huaolan created on 2024/04/04
 */

public interface CouponProvider {

    Coupon applyCoupon(ApplyCouponRequest request);

}
