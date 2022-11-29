package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Product;
import HDT.Oneteam.Repository.ProductReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductReps productReps;

    ///module
    public List<Product> getAllProduct(){
        return productReps.findAll();
    }
    public List<Product> getAllProductOn(int status){
        return productReps.findAllByStatus(status);
    }
    public Product getProductById(int productId){
        return productReps.findById(productId).get();
    }
    public void saveAll(List<Product> productList){
        productReps.saveAll(productList);
    }

    public void save(Product product){
        productReps.save(product);
    }

}