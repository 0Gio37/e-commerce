package fr.cda.ecommerce.model;

public class OrderProduct {

    private Product product;
    private Order order;
    private int quantity;

    public OrderProduct() {
        super();
    }

    public OrderProduct(Order order, Product product, int quantity) {
        super();
        this.product = product;
        this.order = order;
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderProduct [product=" + product + ", quantity=" + quantity + "]";
    }

    public Integer getTotalPrice() {
        return getProduct().getPrice() * getQuantity();
    }

}
