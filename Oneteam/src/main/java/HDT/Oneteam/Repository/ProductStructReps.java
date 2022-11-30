package HDT.Oneteam.Repository;

import HDT.Oneteam.Model.Product;
import HDT.Oneteam.Model.ProductStructure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductStructReps extends JpaRepository<ProductStructure,Integer> {
    void deleteByProduct(Product product);
    void deleteAllByProduct(Product product);
    List<ProductStructure> findAllByProduct(Product product);

}
