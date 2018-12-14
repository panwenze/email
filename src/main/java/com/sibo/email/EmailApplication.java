package com.sibo.email;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@EnableAsync
@ServletComponentScan(basePackages="com.sibo.email")
@MapperScan(basePackages = {"com.sibo.email.mapper"})
public class EmailApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(EmailApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(EmailApplication.class);
    }

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // 线程池维护线程的最少数量
        executor.setMaxPoolSize(200); // 线程池维护线程的最大数量
        executor.setQueueCapacity(200);//线程池所使用的缓冲队列

        executor.setKeepAliveSeconds(600);//线程池维护线程所允许的空闲时间
        executor.setThreadNamePrefix("emailTaskExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());// 设置拒绝策略
        executor.setWaitForTasksToCompleteOnShutdown(true); // 当调度器shutdown被调用时等待当前被调度的任务完成
        executor.setAwaitTerminationSeconds(60);
        return executor;
    }
}
