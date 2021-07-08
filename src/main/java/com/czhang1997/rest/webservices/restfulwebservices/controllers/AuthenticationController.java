package com.czhang1997.rest.webservices.restfulwebservices.controllers;

import com.czhang1997.rest.webservices.restfulwebservices.beans.AuthenticationBean;
import com.czhang1997.rest.webservices.restfulwebservices.beans.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

    @GetMapping(path="/basicAuth")
    public AuthenticationBean authenticationCheck(){
        return new AuthenticationBean("you are good");
    }

    // hello world bean
    @RequestMapping(method = RequestMethod.GET, path="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("hello world, bean");
    }

    @RequestMapping(method = RequestMethod.GET, path="/hello-world/{name}")
    public HelloWorldBean helloWorldPath(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello, World. %s", name));
//        throw new RuntimeException("something went wrong");
    }
}
