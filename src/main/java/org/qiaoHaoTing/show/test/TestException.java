package org.qiaoHaoTing.show.test;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestException {

    public static void main(String[] args) {
        CustomizableThreadFactory customizableThreadFactory = new CustomizableThreadFactory("test-exception-");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(200, 200, 0L,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), customizableThreadFactory);
        for(int i=0; i<200; i++) {
            Run run = new Run();
            threadPoolExecutor.submit(run);
        }
    }

    public static class Run implements Runnable {
        @Override
        public void run() {
            try {
                Map map = new HashMap();
                map.put("key", "3");
                Integer value = (Integer) map.get("key");
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + ExceptionUtils.getStackTrace(e));

            }
        }
    }
}
