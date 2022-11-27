package HDT.Oneteam.Responsibility;

import HDT.Oneteam.Model.BillExportProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BExportProductReps extends JpaRepository<BillExportProduct,Integer> {
    List<BillExportProduct> findAllByStatusOrderByCreatedAsc(int status);
}
