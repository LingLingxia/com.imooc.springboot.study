package com.imooc.springboot.study.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.springboot.study.config.SpringBootConfig;
import com.imooc.springboot.study.vo.Imoocer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/springboot")
public class Controller {

    private final SpringBootConfig springBootConfig;


    private final ObjectMapper mapper;

    @Value("${imooc.springboot.version}")
    private String version;

    @Value("${imooc.springboot.name}")
    private String name;

    @Autowired
    public Controller(SpringBootConfig springBootConfig, ObjectMapper mapper) {
        this.springBootConfig = springBootConfig;
        this.mapper = mapper;
    }

    @GetMapping("/conf_inject_1")
    public void firstConfInject(){
        log.info("first conf inject:{},{}",version,name);
    }

    @GetMapping("/conf_inject_2")
    public void secondConfigInject(){
        log.info("second conf inject:{},{}",springBootConfig.getVersion(),springBootConfig.getName());
    }

    @GetMapping("/jackson")
    public Imoocer jackson() throws Exception{
       Imoocer imoocer = Imoocer.builder()
               .name("myname")
               .age(19)
               .address("shenzhen")
               .registerTime(new Date())
               .build();

       String jsonImoocer = mapper.writeValueAsString(imoocer);
       log.info("imoocer jackson:{}",jsonImoocer);
       //return mapper.readValue(jsonImoocer,Imoocer.class);
        return imoocer;
    }
}
