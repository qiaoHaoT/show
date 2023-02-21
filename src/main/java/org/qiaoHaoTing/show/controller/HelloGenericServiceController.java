package org.qiaoHaoTing.show.controller;

import org.qiaoHaoTing.show.service.HelloGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloGenericServiceController {

    @Autowired
    HelloGenericService helloGenericService;

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    @ResponseBody
    public String getValue() {
        return (String) helloGenericService.sayHello();
    }
}
