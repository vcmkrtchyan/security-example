package org.example.security.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public ModelAndView home() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = ((User) authentication.getPrincipal());

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("username", user.getUsername());

        return modelAndView;
    }

}
