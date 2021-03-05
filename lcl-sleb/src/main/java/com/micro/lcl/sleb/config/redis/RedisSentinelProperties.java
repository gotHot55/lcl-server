package com.micro.lcl.sleb.config.redis;

import lombok.Data;


/**
 * 哨兵配置
 *
 * @author Administrator
 * @date 2021/1/817:39
 */
@Data
public class RedisSentinelProperties {
    /**
     * 哨兵名称
     */
    private String master;
    /**
     * 哨兵节点
     */
    private String nodes;

}
