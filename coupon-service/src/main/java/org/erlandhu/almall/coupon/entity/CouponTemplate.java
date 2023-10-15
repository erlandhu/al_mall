package org.erlandhu.almall.coupon.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author huaolan created on 2023/09/15
 */

@Data
public class CouponTemplate {

    private Integer id;

    private Integer shopId;

    private String couponName;

    private String description;

//    private CouponType couponType;
    private Integer couponType;

    private Integer issuedQuantity;

    private Integer inventory;

    private Integer verifiedQuantity = 0;

    private BigDecimal issuedAmount = BigDecimal.ZERO;

    private Instant startTime;

    private Instant endTime;

    private Integer couponState;
//    private CouponTemplateState couponState;

    private boolean isVisible = true;

    private boolean isRecoverIssued = true; //是否恢复投放

    private Instant stopIssuedAt; // 停止投放时间

    private Integer priority;

    // JSON编码的规则配置
    private String useRule;

    private boolean delFlag;

    private Instant createdAt;

    private Instant updatedAt;

}
