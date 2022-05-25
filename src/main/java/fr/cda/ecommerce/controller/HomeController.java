package fr.cda.ecommerce.controller;

import fr.cda.ecommerce.dto.ClientDTO;
import fr.cda.ecommerce.model.Client;
import fr.cda.ecommerce.security.MyClientPrincipal;
import fr.cda.ecommerce.service.ClientService;
import fr.cda.ecommerce.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public String index(Model model) {
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

    @GetMapping(value = "/register")
    public String register (Model model){
        ClientDTO clientDTO = new ClientDTO();
        model.addAttribute("newClient", clientDTO);
        return "register";
    }

    @RequestMapping(value = "/submit_register", method = RequestMethod.POST)
    public String addClient(@ModelAttribute("newClient") @Valid ClientDTO clientDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("-----> "+bindingResult.toString());
            return "registration";
        }
        try{
            clientService.newClientRegister(clientDTO);
        }catch (Exception e){
            return "register";
        }
        return "/login";
    }





}
