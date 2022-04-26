package fr.cda.ecommerce.service;

import fr.cda.ecommerce.exeption.StockException;
import fr.cda.ecommerce.model.Order;
import fr.cda.ecommerce.model.OrderProduct;
import fr.cda.ecommerce.model.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private final List<Order> allOrder = new ArrayList<>();
    private ProductService productService;

    public OrderServiceImpl(){
        super();
    }

    @Override
    public List<Order> getAllOrders(){
        return allOrder;
    }

    @Override
    public Order create(Order order){
        if(allOrder.contains(order)){
            order.setStatus("En cours");
            allOrder.add(order);
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
