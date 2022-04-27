package fr.cda.ecommerce.service;

import fr.cda.ecommerce.exeption.StockException;
import fr.cda.ecommerce.model.Product;

import java.util.List;

public interface ProductService {
    public abstract List<Product> getAllProducts();
    public abstract Product getProductById(int id);
    public abstract Product save(Product product);
    public abstract boolean isProductAvailable(Product product, int quantity);
    public abstract void removeProduct(Product product, int quantity) throws StockException;
}
