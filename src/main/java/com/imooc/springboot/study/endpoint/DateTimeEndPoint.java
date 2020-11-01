package com.imooc.springboot.study.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Endpoint(id = "datetime")
public class DateTimeEndPoint {
    private String format = "yyyy-MM-dd HH:mm:ss";
    private String anotherString = "another";
    //用来显示监控指标 /imooc-prod/actuator/datetime
    @ReadOperation
    public Map<String,Object> info(){
        Map<String,Object> info = new HashMap<>();
        info.put("name","myName");
        info.put("age","19");
        info.put("datetime",new SimpleDateFormat(format).format(new Date()));
        return info;
    }

    //动态更改监控指标 post方法
    @WriteOperation
    public void setFormat(String f,String a){
        //the json param should be {f:xxx,a:xxx}
        this.format = f;
        this.anotherString = a;
    }
}
