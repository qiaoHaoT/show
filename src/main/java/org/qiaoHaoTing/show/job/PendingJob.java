package org.qiaoHaoTing.show.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class PendingJob {

    private static final Logger logger = LoggerFactory.getLogger(PendingJob.class);

    //@Scheduled(cron = "0 0/1 * * * ?")
    public void run() {
        logger.info("PendingJob is running");
        long start = System.currentTimeMillis() + (2 * 60 * 1000);
        while (true) {
            long end = System.currentTimeMillis();
            if(end >= start) {
                break;
            }
        }
        logger.info("PendingJob is end");
    }
}
