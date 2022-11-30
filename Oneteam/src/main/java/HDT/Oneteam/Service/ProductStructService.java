package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Product;
import HDT.Oneteam.Model.ProductStructure;
import HDT.Oneteam.Repository.ProductStructReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductStructService {
    @Autowired
    private ProductStructReps productStructReps;
    public List<ProductStructure> getStructProduct(Product product){
        return productStructReps.findAllByProduct(product);
    }
}
