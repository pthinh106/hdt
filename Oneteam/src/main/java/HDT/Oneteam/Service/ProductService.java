package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Product;
import HDT.Oneteam.Responsibility.ProductReps;
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
}