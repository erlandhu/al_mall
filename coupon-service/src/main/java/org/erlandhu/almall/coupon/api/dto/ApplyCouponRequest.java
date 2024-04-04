package org.erlandhu.almall.coupon.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author huaolan created on 2020/11/23
 */

@Setter
@Getter
public class ApplyCouponRequest {

    /**
     * 客户id
     */
    private int memberId;

    /**
     * 优惠券模板ID
     */
    private int couponTemplateId;

    /**
     * 门店ID
     */
    private int shopId;

    /**
     * 领取来源
     */
    private String source;

    /**
     * 用于标示领取记录
     */
    private String applyToken;

    /**
     * forceApply true - 无视库存限制、领取限制，可强制领取
     */
    private boolean forceApply;

}
