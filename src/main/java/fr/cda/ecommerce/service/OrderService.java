package fr.cda.ecommerce.service;

import fr.cda.ecommerce.exeption.StockException;
import fr.cda.ecommerce.model.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();
    public Order create(Order order);
    public void update(Order order) throws StockException;
}
