package fr.cda.ecommerce.controller;

import fr.cda.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = {"","/"})
    public String getProducts(Model model){
        model.addAttribute("products", productService.getAllProducts());
       return "products";
    }

    @GetMapping("/{productId}")
    public String getOneProduct(Model model, @PathVariable("productId") int id){
        model.addAttribute("currentCar", productService.getProductById(id));
        System.out.println(id);
        return "productSingle";
    }

}
