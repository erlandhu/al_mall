package org.erlandhu.almall.coupon.repository.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;


@Setter
@Getter
public class SimplePromotion {

    private Integer id;

    private Integer shopId;

    private String promotionName;

    private Integer promotionType;

    private Instant startTime;

    private Instant endTime;

    private Integer promotionState;

    private String applyRule;

    private Integer couponTemplateId;

    // 是否可以转赠优惠券
    private boolean allowTransfer;

    // 需要给会员打的标签
    private String memberTags;

    // 过期提醒提前的天数
    private int remindAheadDays;

    private String sharingConfig;

    private Instant createdAt;

    private Instant updatedAt;

}
