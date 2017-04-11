package com.tm.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2017/4/11.
 */
@RestController
public class FuckService {

    @RequestMapping("/fuck")
    @HystrixCommand(fallbackMethod = "fuckError")
    public String fuck(@RequestParam String name){

        System.out.println("this is ribbon client");
        return "fuck "+name;
    }

    public String fuckError(String name) {
        return "hi,"+name+",come. error!";
    }



}
