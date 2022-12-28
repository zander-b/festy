package com.festy.app.Festy.kitchen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("v1/kitchen")
public class KitchenController {

    @GetMapping
    String getKitchen(Model model) {
        return "kitchen";
    }
}
