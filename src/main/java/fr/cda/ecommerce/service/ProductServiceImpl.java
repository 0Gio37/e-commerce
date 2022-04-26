package fr.cda.ecommerce.service;

import fr.cda.ecommerce.exeption.ResourceNotFoundException;
import fr.cda.ecommerce.exeption.StockException;
import fr.cda.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("products")
public class ProductServiceImpl implements ProductService{
    private final List<Product> allProducts = new ArrayList<>();

    public ProductServiceImpl(){
        super();
    }

    @Override
    public List<Product> getAllProducts(){
       return allProducts;
    }

    @Override
    public Product save(Product product){
        if(allProducts.contains(product)){
            return null;
        }else {
            allProducts.add(product);
            return product;
        }
    }

    @Override
    public boolean isProductAvailable(Product product, int quantity){
        if(product.getQuantity() - quantity > 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void removeProduct(Product product, int quantity) throws StockException{
        if(this.isProductAvailable(product, quantity)){
            product.setQuanity(product.getQuantity() - quantity);
        }else{
            throw new StockException("Ce produit n'a pas assez de stock");
        }
    }

    @Override
    public Product getProductById(Long id){
        for (Product product : allProducts){
            if(product.getId().equals(id)){
                return product;
            }else{
                throw new ResourceNotFoundException("pas de correspondance avec cet ID");
            }
        }
        return null;
    }


}
