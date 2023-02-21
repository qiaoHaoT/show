package org.qiaoHaoTing.show.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public void getInfo() {
        logger.info("start");
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://127.0.0.1:8080/getCode", String.class);
        logger.info(String.valueOf(forEntity.getStatusCodeValue()));
    }

    @RequestMapping(value = "/test/proxy" , method = RequestMethod.GET)
    @ResponseBody
    public String proxy() {
        return "proxy successfully";
    }
}
