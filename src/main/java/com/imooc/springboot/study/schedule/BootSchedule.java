package com.imooc.springboot.study.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
//@Component
public class BootSchedule {
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern(
            "HH:mm:ss"
    );

    @Scheduled(fixedRate = 3000)
    public void schedule01() {
        log.info("schedule01->{}", LocalDateTime.now().format(fmt));
    }

    @Scheduled(fixedDelay = 3000)
    public void schedule02() {
        log.info("schedule02->{}", LocalDateTime.now().format(fmt));
    }

    @Scheduled(initialDelay = 2000, fixedDelay = 3000)
    public void schedule03() {
        log.info("schedule03->{}", LocalDateTime.now().format(fmt));
    }

    @Scheduled(cron = "*/3 * * * * ?")
    public void schedule04() {
        log.info("schedule04->{}", LocalDateTime.now().format(fmt));
    }

}
