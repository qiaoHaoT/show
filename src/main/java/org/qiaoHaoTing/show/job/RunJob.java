package org.qiaoHaoTing.show.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RunJob {

    private static final Logger logger = LoggerFactory.getLogger(RunJob.class);

    //@Scheduled(cron = "0 0/1 * * * ?")
    public void run() {
        logger.info("RunJob is running");
        for(int i=0; i<100;i++) {

        }
        logger.info("RunJob is end");
    }
}
