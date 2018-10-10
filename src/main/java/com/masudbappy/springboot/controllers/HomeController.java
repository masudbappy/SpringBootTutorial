package com.masudbappy.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@ResponseBody it just return data not html page.
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam("name") String name) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.setViewName("home");
        return mv;
    }
}
