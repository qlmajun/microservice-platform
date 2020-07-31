package com.warrior.central.common.config;

import com.warrior.central.common.utils.CustomThreadPoolTaskExecutor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 小马哥
 * @description 异步任务默认配置
 * @date 2020/6/16
 */
@Setter
@Getter
@EnableAsync(proxyTargetClass = true)
public class DefaultAsycTaskConfig {

    /***
     * 线程池维护的核心线程数
     */
    @Value("${asyc-task.corePoolSize:10}")
    private int corePoolSize;

    /***
     * 线程池维护的最大线程数
     */
    @Value("${asyc-task.maxPoolSize:200}")
    private int maxPoolSize;

    /***
     * 队列最大长度
     */
    @Value("${asyc-task.queueCapacity:10}")
    private int queueCapacity;

    /***
     * 线程池前缀
     */
    @Value("${asyc-task.threadNamePrefix:XmgExecutor-}")
    private String threadNamePrefix;

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new CustomThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        /*
           rejection-policy：当pool已经达到max size的时候，如何处理新任务
           CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
