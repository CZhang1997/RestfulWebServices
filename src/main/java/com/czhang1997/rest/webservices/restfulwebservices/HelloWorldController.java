package com.czhang1997.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // GET
    @RequestMapping(method = RequestMethod.GET, path="/hello-world")
    public String helloWorld(){
        return "Hello World!";
    }

    // hello world bean
    @RequestMapping(method = RequestMethod.GET, path="/hello-world-bean")
    public String helloWorldBean(){
        return "Hello World!";
    }
}
