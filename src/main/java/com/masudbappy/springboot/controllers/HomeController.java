package com.masudbappy.springboot.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

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
    public String hello(@AuthenticationPrincipal final UserDetails userDetails){
        String username = userDetails.getUsername();
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        authorities.
                forEach(System.out::println);
        return "hello world";
    }

    @GetMapping("/all")
    public String hello() {
        return "Hello Youtube";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public String securedHello() {
        return "Secured Hello";
    }

    @GetMapping("/secured/alternate")
    public String alternate() {
        return "alternate";
    }
}
