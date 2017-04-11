package com.tm.springcloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2017/4/10.
 */

@RestController
public class HiController {

    @Autowired
    FeignMyServiceClient feignMyServiceClient;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        return feignMyServiceClient.sayHi(name);
    }


}
