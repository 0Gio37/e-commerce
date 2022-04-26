package fr.cda.ecommerce;

import fr.cda.ecommerce.exeption.StockException;
import fr.cda.ecommerce.model.Client;
import fr.cda.ecommerce.model.Order;
import fr.cda.ecommerce.model.OrderProduct;
import fr.cda.ecommerce.service.ClientService;
import fr.cda.ecommerce.service.OrderService;
import fr.cda.ecommerce.service.ProductService;
import fr.cda.ecommerce.model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;

//@SpringBootApplication
public class ECommerceApplication {
//TP2 - lancement via fichier xml
    /*public static void main(String[] args) {
        //SpringApplication.run(ECommerceApplication.class, args);

        // Chargement des beans
        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");

        // --------------------------------------------------
        // Récupération des beans services
        ProductService productService = context.getBean("products", ProductService.class);
        ClientService clientService = context.getBean("clients", ClientService.class);
        OrderService orderService = context.getBean("orders", OrderService.class);

        // --------------------------------------------------
        // Création des instances Product
        Product product1 = new Product(1l, "Produit 1", "desc du prod 1", 12d, "url1", 1);
        Product product2 = new Product(2l, "Produit 2", "desc du prod 2", 32d, "url2", 4);
        Product product3 = new Product(3l, "Produit 3", "desc du prod 3", 22d, "url3", 54);

        // Création des instances Client
        Client client = new Client(1l, "Peter", "1234");

        // Création des instances Order
        Order order = new Order(1l, LocalDate.now(), "null", client, new ArrayList<OrderProduct>());

        // --------------------------------------------------
        // Ajout au bean service product
        productService.save(product1);
        productService.save(product2);
        productService.save(product3);

        // Ajout au bean service client
        clientService.save(client);

        // --------------------------------------------------
        // Affichage
        productService.getAllProducts().stream().forEach(System.out::println);
        clientService.getAllClient().stream().forEach(System.out::println);

        // --------------------------------------------------
        // On ajoute les produits à la commande
        order.addProduct(product2, 2); // ou 5
        order.addProduct(product3, 5);

        // Ajout au bean service order par la méthode de création
        orderService.create(order);

        // Affichage
        System.out.println("--------------------------------------------------");
        System.out.println("Création de la commande : ");
        System.out.println(order);

        // On paie la commande
        try {
            orderService.update(order);
        } catch (StockException e) {
            e.printStackTrace();
        }

        // Affichage
        System.out.println("--------------------------------------------------");
        System.out.println("Mise à jour de la commande : ");
        System.out.println(order);

    }*/

    //Tp3 - lancement via annotations
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ECommerceApplication.class);

    }



}
