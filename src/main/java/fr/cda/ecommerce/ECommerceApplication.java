package fr.cda.ecommerce;

import fr.cda.ecommerce.exeption.StockException;
import fr.cda.ecommerce.model.Client;
import fr.cda.ecommerce.model.Order;
import fr.cda.ecommerce.model.OrderProduct;
import fr.cda.ecommerce.service.ClientService;
import fr.cda.ecommerce.service.ClientServiceImpl;
import fr.cda.ecommerce.service.OrderService;
import fr.cda.ecommerce.service.ProductService;
import fr.cda.ecommerce.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@ComponentScan("fr.*")
@SpringBootApplication
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
        SpringApplication.run(ECommerceApplication.class, args);
/*
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ECommerceApplication.class);
        // Récupération des beans services
        ProductService productService = context.getBean("products", ProductService.class);
        ClientService clientService = context.getBean("clients", ClientService.class);
        OrderService orderService = context.getBean("orders", OrderService.class);

        // Création des instances Product
        Product product1 = new Product(1l, "Produit 1", "desc du prod 1", 12d, "url1", 10);
        Product product2 = new Product(2l, "Produit 2", "desc du prod 2", 32d, "url2", 4);
        Product product3 = new Product(3l, "Produit 3", "desc du prod 3", 22d, "url3", 54);

        // Création des instances Client
        Client client = new Client(1l, "Peter", "1234");

        // Création des instances Order
        Order order = new Order(1l, LocalDate.now(), "null", client, new ArrayList<OrderProduct>());
        order.addProduct(product1, 5);
        orderService.create(order);
        System.out.println(order);

        // On paie la commande
        try {
            orderService.update(order);
        } catch (StockException e) {
            e.printStackTrace();
        }
*/
    }

    @Bean
    public CommandLineRunner runner(ProductService productService, ClientService clientService){
        return args -> {

/*            for (Client client : clientService.getAllClient()
                 ) { client.setPassword(passwordEncoder().encode(client.getPassword()));
                clientService.save(client);
            }*/



//            Product product1 = new Product(1, "Levante","SUV",108500,"levante",10, "2020");
//            Product product2 = new Product(2, "Quattroporte","Berline Elegante",87500,"quattroporte",20, "2020");
//            Product product3 = new Product(3, "Guibli","Berline Sportive",81500,"ghibli",35, "2022");
//            Product product4 = new Product(4, "Grecale","citadine",75500,"grecale",50, "2020");
//            Product product5 = new Product(5, "MC20","GT",150000,"mc20",1,"2022");
//            Product product6 = new Product(6, "3200GT","GT",880000,"3200",4,"1998");
//            Product product7 = new Product(7, "Coupé","coupé",150000,"coupe",12,"2002");
//            Product product8 = new Product(8, "bora","concept Car",65000,"bora",9,"1971");
//            Product product9 = new Product(9, "spyder","cabriolet",60000,"spyder",19,"2001");
//            Product product10 = new Product(10, "alfieri","prototype",200000,"alfieri",1,"2023");

//            Product p2 = productService.save(product5);
           /* Product p2 = productService.save(product6);
            Product p3 = productService.save(product7);
            Product p4 = productService.save(product8);
            Product p5 = productService.save(product9);
            Product p6 = productService.save(product10);*/

            /*productService.save(product2);
            productService.save(product3);
            productService.save(product4);
            productService.save(product5);
            productService.save(product6);
            productService.save(product7);
            productService.save(product8);
            productService.save(product9);
            productService.save(product10);*/
        };
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
