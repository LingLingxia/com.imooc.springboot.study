package com.imooc.springboot.study;


import junit.framework.TestCase;
import junit.framework.TestSuite;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * AsyncService Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>10/29/2020</pre>
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AsyncServiceTest extends TestCase {
    @Autowired
    private AsyncService asyncService;

    @Test
    public void testAsyncProcess() throws Exception {
        //TODO: Test goes here...
        asyncService.asyncProcess();
        log.info("coming in testAsyncProcess...");

    }

    @Test
    public void testAsyncProcessHasReture() throws Exception {
        //TODO: Test goes here...
        long start = System.currentTimeMillis();
        Future<Integer> result = asyncService.asyncProcessHasReture();
        log.info("get async task value:{}",result.get(1, TimeUnit.SECONDS));
        log.info("time elapse for async task:{}ms",
                System.currentTimeMillis()-start);
    }


}
