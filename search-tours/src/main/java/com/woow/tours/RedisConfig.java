package com.woow.tours;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.IOException;

@Configuration
public class RedisConfig {

    @Bean
    public RedissonClient config() throws IOException {
        //var config = Config.fromYAML(ResourceUtils.getFile("classpath:redisson/redisson-config.yml"));
        return null;
    }
}
