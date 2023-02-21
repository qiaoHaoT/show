package org.qiaoHaoTing.show.service;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.service.GenericService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloGenericService {

    private static final Logger log = LoggerFactory.getLogger(HelloGenericService.class);

    private GenericService genericService;

    private Object lockObject = new Object();

    private GenericService helloService() {
        if(genericService != null) {
            return genericService;
        }
        synchronized (lockObject) {
            if(genericService != null) {
                return genericService;
            }
            ReferenceConfig<GenericService> config = new ReferenceConfig<>();
            config.setInterface("com.qiao.hao.ting.service.HelloService");
            config.setGeneric(true);
            config.setProtocol("dubbo");
            config.setCheck(false);
            //config.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
            config.setRegistry(new RegistryConfig("nacos://127.0.0.1:8848"));
            config.setTimeout(1000);
            config.setApplication(new ApplicationConfig("general"));
            genericService = config.get();
        }
        return genericService;
    }

    public Object sayHello() {
        while (true) {
            try {
                GenericService genericService = helloService();
                //genericService.$invoke("syaHello", new String[]{}, new Object[]{});
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        return "success";
    }
}
