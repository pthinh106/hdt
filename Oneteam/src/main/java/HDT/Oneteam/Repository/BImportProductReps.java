package HDT.Oneteam.Repository;

import HDT.Oneteam.Model.BillImportProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BImportProductReps extends JpaRepository<BillImportProduct,Integer> {
    List<BillImportProduct> findAllByStatusOrderByCreatedAsc(int status);
}
