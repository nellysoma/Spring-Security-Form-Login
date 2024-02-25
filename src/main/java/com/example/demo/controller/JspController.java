/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Harmony
 */
@Controller
public class JspController {
    
    @RequestMapping("/url")
    public String page(Model model) {
        model.addAttribute("attribute", "value");
        return "view.name";
    }
    
    @GetMapping("/dashboard.html")
    public String goToDashboard(){
        return "dashboard";
    }
    
    @GetMapping("/home.html")
    public String goToHomePage(){
        return "home";
    }
    
    @GetMapping("/")
    public String goToHomePage1(){
        return "home";
    }
    
    @GetMapping("/login.html")
    public String goToLoginPage(){
        return "login";
    }
    
    @GetMapping("/wrongCredentials.html")
    public String goTowrongCredentialsPage(){
        return "wrongCredentials";
    }
}
