package com.micro.lcl.sleb.config.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/817:31
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis"/*,ignoreUnknownFields = false*/)
@Data
public class RedisProperties {
    private RedisSentinelProperties sentinel;
    private RedisClusterProperties cluster;
    private String password;
    private String host;
    private JedisProperties jedis;
    private Integer port;


}
