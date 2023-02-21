package org.qiaoHaoTing.show.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeController {

    @RequestMapping(value = "/getCode", method = RequestMethod.GET)
    @ResponseBody
    public String getValue() {
        long start = System.currentTimeMillis() + (2 * 60 * 1000);
        while (true) {
            long end = System.currentTimeMillis();
            if(end >= start) {
                break;
            }
        }
        return "ok";
    }


}
