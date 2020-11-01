package com.imooc.springboot.study.endpoint;

import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//自定义端点配置类
@Configuration
public class DateTimeEndpointConfig {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public  DateTimeEndPoint dateTimeEndPoint(){
        return new DateTimeEndPoint();
    }
}

