package com.hutech.ticket.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping(value = { "/admin" , "/admin/login"})
    public String adminHomepage() {
        return "redirect:/adminlte/index.html";
    }
}
