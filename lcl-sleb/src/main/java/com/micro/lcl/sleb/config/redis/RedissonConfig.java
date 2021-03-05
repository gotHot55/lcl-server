package com.micro.lcl.sleb.config.redis;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.google.common.collect.Lists;
import io.micrometer.core.instrument.util.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/817:07
 */
@Configuration
public class RedissonConfig {
    @Autowired
   private RedisProperties redisProperties;

    /**
     * 哨兵模式自动装配
     *
     * @return
     */
    /*
    @ConditionalOnProperty，这个注解能够控制某个configuration是否生效。具体操作是通过其两个属性name以及havingValue来
    实现的，其中name用来从application.properties中读取某个属性值，如果该值为空，则返回false;如果值不为空，
    则将该值与havingValue指定的值进行比较，如果一样则返回true;否则返回false。如果返回值为false，
    则该configuration不生效；为true则生效。
     */
    @Bean(destroyMethod = "shutdown")
    @ConditionalOnProperty(name="spring.redis.strategy", havingValue = "3")
    public RedissonClient redissonSentinel() {
        Config config = new Config();
        String[] nodes = redisProperties.getSentinel().getNodes().split(",");
        List<String> newNodes = new ArrayList(nodes.length);
        Arrays.stream(nodes).forEach((index) -> newNodes.add(
                index.startsWith("redis://") ? index : "redis://" + index));
        SentinelServersConfig sentinelServersConfig = config.useSentinelServers()
                .addSentinelAddress(newNodes.toArray(new String[0]))
                .setMasterName(redisProperties.getSentinel().getMaster())
                .setMasterConnectionPoolSize(250)
                .setSlaveConnectionPoolSize(250);
        if (StringUtils.isNotBlank(redisProperties.getPassword())) {
            sentinelServersConfig.setPassword(redisProperties.getPassword());
        }
        config.setCodec(new JsonJacksonCodec(objectMapper()));
        return Redisson.create(config);
    }

    /**
     * 集群模式自动装配
     *
     * @return
     */
    @Bean(destroyMethod = "shutdown")
    @ConditionalOnProperty(name="spring.redis.strategy", havingValue = "2")
    public RedissonClient redissonCluster() {
        Config config = new Config();
        List<String> nodes = Collections.singletonList(redisProperties.getCluster().getNodes());
        List<String> newNodes = Lists.newArrayListWithCapacity(nodes.size());
        nodes.forEach((index) -> newNodes.add(
                index.startsWith("redis://") ? index : "redis://" + index));
        ClusterServersConfig clusterServersConfig = config.useClusterServers()
                .addNodeAddress(newNodes.toArray(new String[0]));
        if (StringUtils.isNotBlank(redisProperties.getPassword())) {
            clusterServersConfig.setPassword(redisProperties.getPassword());
        }
        config.setCodec(new JsonJacksonCodec(objectMapper()));
        return Redisson.create(config);
    }

    /**
     * 单机模式自动装配
     *
     * @return
     */
    @Bean(destroyMethod = "shutdown")
    @ConditionalOnProperty(name="spring.redis.strategy", havingValue = "1")
    public RedissonClient redissonSingle() {
        Config config = new Config();
        String redisAddress=String.format("redis://%s:%d",redisProperties.getHost(),redisProperties.getPort());
        SingleServerConfig singleServerConfig = config.useSingleServer()
                .setAddress(redisAddress)
                .setConnectionMinimumIdleSize(redisProperties.getJedis().getPool().getMinIdle());
        if (StringUtils.isNotBlank(redisProperties.getPassword())) {
            singleServerConfig.setPassword(redisProperties.getPassword());
        }
        config.setCodec(new JsonJacksonCodec(objectMapper()));
        return Redisson.create(config);
    }

    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        //大小写不敏感
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        mapper.registerModule(javaTimeModule);
        return mapper;
    }
}
