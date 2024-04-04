package org.erlandhu.almall.coupon.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

@Getter
@AllArgsConstructor
public enum CouponTemplateState {

    NEW(0, "未开始", true),

    START(1, "进行中", true),

    END(2, "结束", false),

    STOP_ISSUE(3, "停止发放", false),

    ;

    private final int state;
    private final String desc;
    private final boolean isAvailable;

    public static boolean isAvailable(int state) {
        AtomicBoolean isAvailable = new AtomicBoolean(false);
        Arrays.stream(values()).filter(e -> e.getState() == state)
                .findFirst().ifPresent(s -> isAvailable.set(s.isAvailable));
        return isAvailable.get();
    }
}
