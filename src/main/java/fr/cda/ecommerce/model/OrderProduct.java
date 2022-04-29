package fr.cda.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="table_order_product")
public class OrderProduct {

    @EmbeddedId
    private OrderProductId id;

    @ManyToOne
    @JoinColumn(name = "fk_product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "fk_order_id", insertable = false, updatable = false)
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
    @JsonIgnore
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
