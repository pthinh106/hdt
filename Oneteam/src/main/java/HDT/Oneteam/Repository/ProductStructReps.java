package HDT.Oneteam.Repository;

import HDT.Oneteam.Model.Product;
import HDT.Oneteam.Model.ProductStructure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStructReps extends JpaRepository<ProductStructure,Integer> {
    void deleteByProduct(Product product);
}
