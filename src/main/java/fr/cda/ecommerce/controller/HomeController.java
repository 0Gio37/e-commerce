package fr.cda.ecommerce.controller;

import fr.cda.ecommerce.service.ClientService;
import fr.cda.ecommerce.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String index(Model model) {
        //model.addAttribute("testUsername", "gio");
        model.addAttribute("listeClient", clientService.getAllClient());
    return "home";


    }
}
