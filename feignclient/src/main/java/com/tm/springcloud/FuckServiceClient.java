package com.tm.springcloud;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lenovo on 2017/4/11.
 */

@FeignClient(value = "ribbon-client")
public interface FuckServiceClient {

    @RequestMapping(value = "/fuck",method = RequestMethod.GET)
    String fuck(@RequestParam(value = "name") String name);

}
