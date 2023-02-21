package org.qiaoHaoTing.show.service;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.*;

@Service
public class ThreadLocalService {

    ThreadFactory springThreadFactory = new CustomizableThreadFactory("TheadLocal-demo-");

    ExecutorService executorService = new ThreadPoolExecutor(10, 10, 60,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(), springThreadFactory);

    ExecutorService service = new ThreadPoolExecutor(10, 10, 60,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    public Object setValue() {
        for(; ;) {
            try {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        String id = UUID.randomUUID().toString();
                        // add
                        ThreadLocalManger.setValue(id, "this is a value");
                        //do something
                        ThreadLocalManger.getValue(id);
                        // clear()
                        //ThreadLocalManger.clear();
                    }
                };
                executorService.submit(runnable);
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
//            BaseRunnable baseRunnable = new BaseRunnable(){
//                @Override
//                public void task() {
//                    String id = UUID.randomUUID().toString();
//                    setArg(id, "base value");
//                    // do something
//                    getArg(id);
//                }
//            };
//            service.submit(baseRunnable);
        }
        return "success";
    }

}
