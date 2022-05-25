package fr.cda.ecommerce.controller;

import fr.cda.ecommerce.security.MyClientPrincipal;
import fr.cda.ecommerce.service.ClientService;
import fr.cda.ecommerce.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @GetMapping("/login")
    public String login (Model model){
        return "login";

    }

    @GetMapping("/logout")
    public String logout (Model model){
        return "logout";
    }

    @GetMapping("jp")
    public String jp (Model model){
        return "jp";
    }


}
