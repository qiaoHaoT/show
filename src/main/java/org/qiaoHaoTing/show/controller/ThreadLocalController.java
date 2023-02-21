package org.qiaoHaoTing.show.controller;

import org.qiaoHaoTing.show.service.ThreadLocalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;

@RestController
public class ThreadLocalController {

    private static final Logger logger = LoggerFactory.getLogger(ThreadLocalController.class);

    @Autowired
    ThreadLocalService service;

    @RequestMapping(value = "/thread/start", method = RequestMethod.GET)
    @ResponseBody
    public String getValue() {
        return (String) service.setValue();
    }

    @RequestMapping(value = "/jvm/PretenureSizeThreshold/not/more/than", method = RequestMethod.GET)
    @ResponseBody
    public String notMoreThan() {

        Executors.newFixedThreadPool(20);


        List<Object> objects = new ArrayList<>();
        while(true) {
            try {
                Enhancer enhancer = new Enhancer();
                enhancer.setUseCache(false);
                enhancer.setCallback((MethodInterceptor) (obj, method, args, proxy) -> obj);
                enhancer.setSuperclass(HashMap.class);
                objects.add(enhancer.create());
            } catch (Throwable e) {
                logger.error("error", e);
                break;
            }
        }
        return "ok";

    }//-XX:NewRatio=1 -XX:+UseSerialGC -XX:+UseParNewGC -XX:+UseG1GC  -XX:PermSize=64m -XX:MaxPermSize=64m -XX:PretenureSizeThreshold=1M

}
