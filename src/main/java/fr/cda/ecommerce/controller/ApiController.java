package fr.cda.ecommerce.controller;

import fr.cda.ecommerce.model.Client;
import fr.cda.ecommerce.model.Order;
import fr.cda.ecommerce.model.Product;
import fr.cda.ecommerce.security.MyClientPrincipal;
import fr.cda.ecommerce.service.ClientService;
import fr.cda.ecommerce.service.OrderService;
import fr.cda.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/clients")
    public List<Client> getClients(Model model) {
        return clientService.getAllClient();
    }

    @GetMapping(value = "/products")
    public List<Product> getProducts(Model model){
        return productService.getAllProducts();
    }

    @GetMapping(value = "/client")
    public Optional<Client> findByUsername(@RequestParam String username){
        return clientService.findByUsername(username);
    }

    @GetMapping(value = "/order")
    public List<Order> getAllOrder(Model model){
        return orderService.getAllOrders();
    }

    @GetMapping("/principal")
    public MyClientPrincipal principal (Model model){
        MyClientPrincipal clientPrincipal = (MyClientPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return clientPrincipal;
    }

    @GetMapping("/test")
    public Principal test (Principal princ){
        return princ;
    }



}
