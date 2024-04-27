package com.Team4.SmartTowns.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("security/login");
    }

    @GetMapping("/login/success")
    public ModelAndView loginSuccess() {
        return new ModelAndView("security/loginSuccess");
    }

    @GetMapping("/login/error")
    public ModelAndView loginError() {
        return new ModelAndView("security/loginError");
    }
}