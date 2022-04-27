package fr.cda.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index() {
    return"home";
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
