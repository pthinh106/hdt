package HDT.Oneteam.Repository;

import HDT.Oneteam.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReps extends JpaRepository<Product,Integer> {
    List<Product> findAllByStatus(int status);
}
