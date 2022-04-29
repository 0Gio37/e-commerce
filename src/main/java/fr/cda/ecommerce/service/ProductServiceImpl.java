package fr.cda.ecommerce.service;

import fr.cda.ecommerce.exeption.ResourceNotFoundException;
import fr.cda.ecommerce.exeption.StockException;
import fr.cda.ecommerce.model.Product;
import fr.cda.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("products")
public class ProductServiceImpl implements ProductService {
    //private final List<Product> allProducts = new ArrayList<>();

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        if (productRepository.findAll().contains(product)) {
            return null;
        } else {
            return productRepository.save(product);
        }
    }

    @Override
    public boolean isProductAvailable(Product product, int quantity) {
        if (product.getQuantity() - quantity > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void removeProduct(Product product, int quantity) throws StockException {
        if (this.isProductAvailable(product, quantity)) {
            product.setQuanity(product.getQuantity() - quantity);
            productRepository.save(product);
        } else {
            throw new StockException("Ce produit n'a pas assez de stock");
        }
    }

    /*
    @Override
 /*   public Product getProductById(int id) {
        return allProducts.stream().filter(p -> p.getId()== id).findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("pas de correspondance avec cet ID"));
    }*/

/*    public Product getProductById(int id){
        int i = 0;
        while (i < productRepository.findAll().size()){
            if(productRepository.findAll().get(i).getId() == id){
                return productRepository.findAll().get(i);
            }
            i++;
        }
        return null;
    }*/

    @Override
    public Product getProductById(long id) throws ResourceNotFoundException{
        if(productRepository.findById(id).isPresent()){
            return productRepository.getById(id);
        }else{
            throw new ResourceNotFoundException("Pas de correspondance d'ID");
        }
    }
}
