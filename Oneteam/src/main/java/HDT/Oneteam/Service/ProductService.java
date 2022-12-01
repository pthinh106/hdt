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
            try {
                productReps.save(product.get());
            }catch (Exception e){
                return false;
            }

            return true;
        }
        return false;
    }

    public boolean createProduct(Product product, int[] materialId, double[] quantity) {
        if(quantity.length < 1){
            return false;
        }
        product.setStatus(1);
        product.setInventoryV1(product.getInventory());
        productReps.save(product);
        for(int i = 0; i<quantity.length;i++){
            if(quantity[i] == 0){
                continue;
            }
            Material material = materialService.getMaterialById(materialId[i]);
            ProductStructure productStructure = new ProductStructure();
            productStructure.setProduct(product);
            productStructure.setMaterial(material);
            productStructure.setQuantity(quantity[i]);
            try {
                productStructReps.save(productStructure);
            }catch (Exception e){
                return false;
            }

        }
        return true;
    }

    public boolean updateProduct(Product product, int[] materialId, double[] quantity) {
        if(quantity.length < 1){
            return false;
        }
        Optional<Product> product1 = productReps.findById(product.getProductId());
        if(product1.isPresent()){
            product1.get().setProductName(product.getProductName());
            product1.get().setInventory(product.getInventory());
            product1.get().setInventoryV1(product.getInventory());
            product1.get().setInventoryV2(product.getInventory());
            product1.get().setUnit(product.getUnit());
            product1.get().setPrice(product.getPrice());
            try {
                productReps.save(product1.get());
            }catch (Exception e){
                return false;
            }

            try {
                for(ProductStructure productStructure : product1.get().getProductStructureList()){
                    productStructReps.deleteById(productStructure.getProductStructureId());
                }
            }catch (Exception e){
                System.out.println("error");
            }

            for(int i = 0; i<quantity.length;i++){
                if(quantity[i] == 0){
                    continue;
                }
                Material material = materialService.getMaterialById(materialId[i]);
                ProductStructure productStructure = new ProductStructure();
                productStructure.setProduct(product1.get());
                productStructure.setMaterial(material);
                productStructure.setQuantity(quantity[i]);
                try {
                    productStructReps.save(productStructure);
                }catch (Exception e){
                    System.out.println("fail");
                    return false;
                }
            }
            return true;
        }else{
            return false;
        }

    }
}
