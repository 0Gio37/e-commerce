package fr.cda.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private Integer price;
    private String picture;
    private Integer quantity;
    private String millesime;

    public Product() {
        super();
    }


    public Product(long id, String name, String description, Integer price, String picture, Integer quantity, String millesime) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.quantity = quantity;
        this.millesime = millesime;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public String getPicture() {
        return picture;
    }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuanity(Integer quantity){
        this.quantity = quantity;
    }

    public String getMillesime(){
        return millesime;
    }



    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
                + ", picture=" + picture + ", quantity=" + quantity + "]";
    }

}
