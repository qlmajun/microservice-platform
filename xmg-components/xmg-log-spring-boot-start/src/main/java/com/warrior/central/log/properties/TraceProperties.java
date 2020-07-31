package com.warrior.central.log.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author majun
 * @description 日志链路追踪配置属性
 * @date 2020/6/12
 */

@ConfigurationProperties(prefix = "xmg.trace")
@RefreshScope
@Getter
@Setter
public class TraceProperties {

    /***
     * 是否开启日志链路追踪
     */
    private Boolean enable = false;
}
