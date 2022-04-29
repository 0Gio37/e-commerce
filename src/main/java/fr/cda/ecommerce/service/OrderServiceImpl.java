package fr.cda.ecommerce.service;

import fr.cda.ecommerce.exeption.StockException;
import fr.cda.ecommerce.model.Order;
import fr.cda.ecommerce.model.OrderProduct;
import fr.cda.ecommerce.model.Product;
import fr.cda.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("orders")
public class OrderServiceImpl implements OrderService {

    //private final List<Order> allOrder = new ArrayList<>();

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderRepository orderRepository;

    public OrderServiceImpl(){
        super();
    }

    @Override
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }


    @Override
    public Order create(Order order){
        if(orderRepository.findAll().contains(order)){
            order.setStatus("En cours");
            orderRepository.save(order);
            return order;
        }else {
            return null;
        }
    }

    @Override
    public void update(Order order) throws StockException{
        if (!order.getStatus().equals("Payée")) {
            for (OrderProduct orderProduct : order.getOrderProducts()) {
                if (!productService.isProductAvailable(orderProduct.getProduct(), orderProduct.getQuantity())) {
                    throw new StockException("Produit plus en stock");
                }
            }
            order.setStatus("Payée");
            orderRepository.save(order);
            for (OrderProduct orderProduct : order.getOrderProducts()) {
                productService.removeProduct(orderProduct.getProduct(), orderProduct.getQuantity());
            }
        }
    }

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

}
