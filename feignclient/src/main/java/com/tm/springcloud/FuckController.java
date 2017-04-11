package com.tm.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2017/4/11.
 */


@RestController
public class FuckController {

    @Autowired
    FuckServiceClient fuckServiceClient;

    @RequestMapping(value = "/fuck",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "fuckError")
    public String fuck(@RequestParam String name){
        System.out.println("this is feign client");
        return fuckServiceClient.fuck(name);
    }


    public String fuckError(String name) {
        return "hi,"+name+",come baby. comming!";
    }

}
