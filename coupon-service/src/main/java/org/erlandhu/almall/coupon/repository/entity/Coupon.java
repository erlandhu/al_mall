package org.erlandhu.almall.coupon.repository.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;


@Data
public class Coupon {

    private Long id;
    private Integer shopId;
    private Integer couponTemplateId;
    private Integer memberId;
    private String memberName;
    private String memberPhone;
    private String couponCode;
    private Integer couponType;
    private BigDecimal discountAmount;
    private Instant startTime;
    private Instant endTime;
    private String source;
    private Integer verificationType;
    private Boolean canReturn; //是否可退
    private CouponState state;
    private Instant createdAt;
    private Instant updatedAt;
    private String consumeBy;
    private String consumeName;
    private Integer consumeShopId;
    private String consumeShopName;

    /**
     * 核销时间, 下单、consume-service 修改
     */
    private Instant usedAt;


}
