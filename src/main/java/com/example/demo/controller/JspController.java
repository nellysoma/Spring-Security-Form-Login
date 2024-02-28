/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.unbescape.html.HtmlEscape;

/**
 *
 * @author Harmony
 */
@Controller
public class JspController {
    
     @RequestMapping("/")
    public String root(Locale locale) {
        return "redirect:/home.html";
    }
    
    @RequestMapping("/dashboard.html")
    public String goToDashboard(){
        return "dashboard";
    }
    
    @RequestMapping("/home.html")
    public String goToHomePage(){
        return "home";
    }
    
    /**@RequestMapping("/")
    public String goToHomePage1(){
        return "home";
    }**/
    
    @RequestMapping("/login.html")
    public String goToLoginPage(){
        return "login";
    }
    
    @RequestMapping("/wrongCredentials.html")
    public String goTowrongCredentialsPage(){
        return "wrongCredentials";
    }
    
     @RequestMapping("/admin/home.html")
    public String goToAdminHomePage() {
        return "admin/home";
    }
    
    /** User zone index. */
    @RequestMapping("/user/home.html")
    public String userIndex() {
        return "user/home";
    }
    
     /** Shared zone index. */
    @RequestMapping("/shared/home.html")
    public String sharedIndex() {
        return "shared/home";
    }
    
    /** Simulation of an exception. */
    @RequestMapping("/simulateError.html")
    public void simulateError() {
        throw new RuntimeException("This is a simulated error message");
    }

    /** Error page. */
    @RequestMapping("/error.html")
    public String error(HttpServletRequest request, Model model) {
        model.addAttribute("errorCode", "Error " + request.getAttribute("javax.servlet.error.status_code"));
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append("<ul>");
        while (throwable != null) {
            errorMessage.append("<li>").append(HtmlEscape.escapeHtml5(throwable.getMessage())).append("</li>");
            throwable = throwable.getCause();
        }
        errorMessage.append("</ul>");
        model.addAttribute("errorMessage", errorMessage.toString());
        return "error";
    }

    /** Error page. */
    @RequestMapping("/403.html")
    public String forbidden() {
        return "403";
    }
    
}
