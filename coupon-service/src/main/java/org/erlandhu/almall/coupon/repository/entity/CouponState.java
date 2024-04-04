package org.erlandhu.almall.coupon.repository.entity;

public enum CouponState {
    // 未使用
    UNUSED,
    // 被锁定
    LOCKED,
    // 已使用
    USED,
    EXPIRED, // 已过期
    DEPRECATED, // 退款退券旧券作废，退换新券
    BANNED, // 停止用券
    FREEZE; // 满减满赠活动返还优惠券的状态为freeze，订单支付成功更改为

    public static CouponState valueOf(int ordinal) {
        switch (ordinal) {
            case 0:
                return UNUSED;
            case 1:
                return LOCKED;
            case 2:
                return USED;
            case 3:
                return EXPIRED;
            case 4:
                return DEPRECATED;
            case 5:
                return BANNED;
            case 6:
                return FREEZE;

            default:
                throw new IllegalStateException("Unexpected value: " + ordinal);
        }

    }

}
