package com.queueup.qup.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/key")
public class AdminKeyController {
    @GetMapping
    public String openAdminKeyPage(){
        return "admin/key";
    }
}
