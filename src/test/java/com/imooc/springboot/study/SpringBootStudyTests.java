package com.imooc.springboot.study;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootStudyTests {

    @Test
    public void contextLoad(){
        int a = 5;
        assert(a>0);
    }
}
