package com.imooc.springboot.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class SpringBootStudyApplication {
    public static void main(String[] args) {
        //1.通过静态run方法,常用
        SpringApplication.run(SpringBootStudyApplication.class,args);


//        //2.通过api调整应用行为，不常用
//
//        SpringApplication application =
//                new SpringApplication(SpringBootStudyApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.setWebApplicationType(WebApplicationType.NONE);
//        application.run(args);

//        //3.SpringApplicationBuilder Fluent Api,链式调用，不常用
//        new SpringApplicationBuilder(SpringBootStudyApplication.class)
//                .bannerMode(Banner.Mode.OFF)
//                .web(WebApplicationType.NONE)
//                .run(args);
    }
}
