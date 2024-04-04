package org.erlandhu.almall.coupon.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author huaolan created on 2024/04/04
 */

@Configuration
public class RedissonConfig {


    @Bean
    public RedissonClient redissonClient(RedisProperties redisProperties) {
        Config config = new Config()
                .setCodec(new JsonJacksonCodec());
        config.useSingleServer()
                .setAddress("redis://" + redisProperties.getHost() + ":" + redisProperties.getPort())
                .setDatabase(redisProperties.getDatabase())
                .setPassword(redisProperties.getPassword());

        return Redisson.create(config);
    }

}
