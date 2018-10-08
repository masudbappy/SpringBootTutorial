package com.masudbappy.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@ResponseBody it just return data not html page.
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index() {
        return "home";
    }
}
