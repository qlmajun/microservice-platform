package com.warrior.central.ribbon;

import com.warrior.central.common.constant.ConfigConstants;
import com.warrior.central.ribbon.config.RuleConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * 自定义负载均衡配置
 * @author majun
 * @date 2020/7/29
 */
@ConditionalOnProperty(value = ConfigConstants.CONFIG_RIBBON_ISOLATION_ENABLED, havingValue = "true")
@RibbonClients(defaultConfiguration = {RuleConfig.class})
public class LbIsolationAutoConfigure {
}
