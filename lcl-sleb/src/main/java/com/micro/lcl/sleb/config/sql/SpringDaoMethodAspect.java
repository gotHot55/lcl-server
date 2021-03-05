package com.micro.lcl.sleb.config.sql;

import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * druid sring监控
 *
 * @author Administrator
 * @date 2021/2/210:45
 */
@Configuration
public class SpringDaoMethodAspect {
    @Bean
    public DruidStatInterceptor druidStatInterceptor() {
        return new DruidStatInterceptor();
    }

    @Bean
    @Scope("prototype")
    public JdkRegexpMethodPointcut methodPointcut() {
        JdkRegexpMethodPointcut pointcut = new JdkRegexpMethodPointcut();
        pointcut.setPattern("com.micro.lcl.*");
        return pointcut;
    }

    @Bean
    public DefaultPointcutAdvisor pointcutAdvisor(DruidStatInterceptor statInterceptor, JdkRegexpMethodPointcut methodPointcut) {
        DefaultPointcutAdvisor pointcutAdvisor = new DefaultPointcutAdvisor();
        pointcutAdvisor.setPointcut(methodPointcut);
        pointcutAdvisor.setAdvice(statInterceptor);
        return pointcutAdvisor;
    }
}
