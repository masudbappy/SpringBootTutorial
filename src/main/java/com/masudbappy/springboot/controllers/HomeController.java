package com.masudbappy.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//@Controller
//@ResponseBody it just return data not html page.
@RestController
@RequestMapping("rest/hello")
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam("name") String name) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.setViewName("home");
        return mv;
    }

    @GetMapping
    public String hello(){
        return "hello world";
    }
}
