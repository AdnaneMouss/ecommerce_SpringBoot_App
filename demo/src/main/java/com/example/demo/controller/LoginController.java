package com.example.demo.controller;
import java.util.Objects;

import com.example.demo.modele.Comptes;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.example.demo.service.Loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoginController {
    @Autowired
    private Loginservice userService;
    @GetMapping("/login")
    public ModelAndView Comptes() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Comptes());
        return mav;
    }
    @PostMapping("/login")
    public String Comptes(@ModelAttribute("user") Comptes user ) {
        Comptes oauthUser = userService.login(user.getUsername(), user.getPassword());
        if(Objects.nonNull(oauthUser))
        {
            return "redirect:shop.html";
        } else {
            return "redirect:/login";
        }
    }
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
        return "redirect:/login";
    }

}