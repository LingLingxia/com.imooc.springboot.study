package com.imooc.springboot.study.config;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@Configuration
public class AsyncPoolConfig implements AsyncConfigurer {

    @Bean
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor =new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);//核心线程数量，默认1
        executor.setMaxPoolSize(20);//申请超过核心线程数的数量
        executor.setQueueCapacity(20);//缓冲队列
        executor.setKeepAliveSeconds(60);//超过核心数量的线程池在空闲时候的存活时间
        executor.setThreadNamePrefix("ImoocAsync_");//线程名前缀

        executor.setWaitForTasksToCompleteOnShutdown(true);//是否等待所有线程执行完毕后再退出，默认为false
        executor.setAwaitTerminationSeconds(60);//shutdown后的等待时长


        executor.setRejectedExecutionHandler(
                new ThreadPoolExecutor.AbortPolicy()
        );
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        //只处理没有返回值的任务
        return new AsyncExceptionHandle();
    }
    class AsyncExceptionHandle implements AsyncUncaughtExceptionHandler{
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
            log.info("AsyncError:{},Method:{},Param:{}",
                    throwable.getMessage(),
                    method.getName(),
                    JSON.toJSONString(objects));
            throwable.printStackTrace();
        }
    }
}
