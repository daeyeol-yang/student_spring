package com.nhnacademy.springmvc.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession(true);

        if(session != null){
            session.invalidate();
            Cookie cookie = new Cookie("SESSION", null);
            response.addCookie(cookie);
        }
        return "redirect:/login";
    }

}
