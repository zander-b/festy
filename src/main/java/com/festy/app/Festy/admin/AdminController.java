package com.festy.app.Festy.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("v1/admin")
public class AdminController {

    @GetMapping
    public String getDashboard(Model model){
        return "AdminDashboard";
    }

}
