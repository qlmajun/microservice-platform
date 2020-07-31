package com.warrior.central.log.config;

import com.warrior.central.log.properties.AuditLogProperties;
import com.warrior.central.log.properties.LogDbProperties;
import com.warrior.central.log.properties.TraceProperties;
import com.zaxxer.hikari.HikariConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author majun
 * @description 日志自动配置
 * @date 2020/6/12
 */
@EnableConfigurationProperties({AuditLogProperties.class, TraceProperties.class})
public class LogAutoConfig {

    /**
     * 日志数据库配置
     */
    @Configuration
    @ConditionalOnClass(HikariConfig.class)
    @EnableConfigurationProperties(LogDbProperties.class)
    public static class LogDbAutoConfigure {

    }
}
