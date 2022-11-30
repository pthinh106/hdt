package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Material;
import HDT.Oneteam.Model.Product;
import HDT.Oneteam.Model.ProductStructure;
import HDT.Oneteam.Repository.ProductReps;
import HDT.Oneteam.Repository.ProductStructReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductReps productReps;
    @Autowired
    private ProductStructReps productStructReps;
    @Autowired
    private MaterialService materialService;

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

    public boolean deleteProduct(int id) {
        Optional<Product> product = productReps.findById(id);
        if(product.isPresent()){
            product.get().setStatus(0);
            productReps.save(product.get());
            return true;
        }
        return false;
    }

    public boolean createProduct(Product product, int[] materialId, int[] quantity) {
        if(quantity.length < 1){
            return false;
        }
        product.setStatus(1);
        productReps.save(product);
        for(int i = 0; i<quantity.length;i++){
            Material material = materialService.getMaterialById(materialId[i]);
            ProductStructure productStructure = new ProductStructure();
            productStructure.setProduct(product);
            productStructure.setMaterial(material);
            productStructure.setQuantity(quantity[i]);
            productStructReps.save(productStructure);
        }
        return true;
    }
}
