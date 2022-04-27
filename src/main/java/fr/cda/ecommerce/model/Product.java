package fr.cda.ecommerce.model;

public class Product {

    private int id;
    private String name;
    private String description;
    private Integer price;
    private String picture;
    private Integer quantity;

    public Product() {
        super();
    }

    public Product(int id, String name, String description, Integer price, String picture, Integer quantity) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.quantity = quantity;
    }

    public int getId() {
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



    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
                + ", picture=" + picture + ", quantity=" + quantity + "]";
    }

}
