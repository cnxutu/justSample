package com.example.demo5.common.config;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component("mallRedissonConfiguration")
@Slf4j
public class RedissonConfiguration {

    @Value("${spring.profiles.active}")
    private String active;
    @Value("${hwRedis.redisson:0}")
    private String redissonYaml;

    @Bean
    public RedissonClient redissonClient() throws IOException {
        return Redisson.create(getRedissonConfig());
    }

    public Config getRedissonConfig() throws IOException {
        if ("0".equals(redissonYaml)) {
            log.info("redisson_init_redissJson_is_null");
            String linuxPH = "config/" + active + "/redisson.yaml";
            InputStream stream = getClass().getClassLoader().getResourceAsStream(linuxPH);
            return Config.fromYAML(stream);
        } else {
            return Config.fromYAML(redissonYaml);
        }
    }


}
