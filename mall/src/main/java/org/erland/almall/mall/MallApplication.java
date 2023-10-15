package org.erland.almall.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author huaolan created on 2023/09/02
 */

@EnableFeignClients
@SpringBootApplication
public class MallApplication {


    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }
}
