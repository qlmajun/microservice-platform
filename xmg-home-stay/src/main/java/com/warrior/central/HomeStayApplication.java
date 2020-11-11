package com.warrior.central;

import com.warrior.central.ribbon.annotation.EnableFeignInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 民宿服务启动类
 * @author mj
 * @date 2020/10/30
 */
@EnableFeignClients
@EnableFeignInterceptor
@EnableDiscoveryClient
@SpringBootApplication
@EnableScheduling
public class HomeStayApplication {

  public static void main(String[] args) {
    SpringApplication.run(HomeStayApplication.class,args);
  }
}
