package com.festy.app.Festy.status;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("v1/status")
public class StatusController {
    @GetMapping
    String getPeople(Model model){
//        model.addAttribute("something", "this is coming from the controller");
//        model.addAttribute("people", Arrays.asList(
//                new Person("Jhon", 26),
//                new Person("James", 22),
//                new Person("Bonny", 29)
//
//        ));

        return "status";
    }

}
