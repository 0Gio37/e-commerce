package fr.cda.ecommerce.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "table_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate dateCreated;
    private String status;

    @ManyToOne
    @JoinColumn(name="fk_client_id")
    private Client client;

    @OneToMany
    @JoinColumn(name="fk_order_id")
    private List<OrderProduct> orderProducts;



    public Order() {
        super();
    }

    public Order(Long id, LocalDate dateCreated, String status, Client client, List<OrderProduct> orderProducts) {
        super();
        this.id = id;
        this.dateCreated = dateCreated;
        this.status = status;
        this.client = client;
        this.orderProducts = orderProducts;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", dateCreated=" + dateCreated + ", status=" + status + ", client=" + client
                + ", orderProducts=" + orderProducts + "]";
    }

    public Double getTotalOrderPrice() {
        double sum = 0D;
        for (OrderProduct op : orderProducts) {
            sum += op.getTotalPrice();
        }
        return sum;
    }

    public int getNumberOfProducts() {
        return this.orderProducts.size();
    }

    public int getTotalNumberOfProducts() {
        int sum = 0;
        for (OrderProduct op : orderProducts) {
            sum += op.getQuantity();
        }
        return sum;
    }

    public void addProduct(Product product, int quantity) {
        OrderProduct orderProduct = null;

        // On regarde si le produit est d??j?? dans la commande, dans ce cas on ajoute seulement la quantit??
        for (OrderProduct op: orderProducts) {
            if (op.getProduct().equals(product)) {
                orderProduct = op;
                orderProduct.setQuantity(op.getQuantity() + quantity);
                break;
            }
        }

        // Sinon on ajoute une nouvelle ligne de commande
        if (orderProduct == null) {
            orderProduct = new OrderProduct(this, product, quantity);
            orderProducts.add(orderProduct);
        }
    }

}
