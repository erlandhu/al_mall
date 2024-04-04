package org.erlandhu.almall.coupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author huaolan created on 2023/09/02
 */

@SpringBootApplication
@MapperScan("org.erlandhu.almall.coupon.repository.mapper")
public class CouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponApplication.class);
    }

}
