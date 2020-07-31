package com.warrior.central.common.context;

import com.alibaba.ttl.TransmittableThreadLocal;

/***
 * 负载均衡策略Holder
 * @author 小马哥
 * @date 2020/06/19
 */
public class LbIsolationContextHolder {
    private static final ThreadLocal<String> VERSION_CONTEXT = new TransmittableThreadLocal<>();

    public static void setVersion(String version) {
        VERSION_CONTEXT.set(version);
    }

    public static String getVersion() {
        return VERSION_CONTEXT.get();
    }

    public static void clear() {
        VERSION_CONTEXT.remove();
    }
}
