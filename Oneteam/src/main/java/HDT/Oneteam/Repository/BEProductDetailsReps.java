package HDT.Oneteam.Repository;

import HDT.Oneteam.Model.BillExportProduct;
import HDT.Oneteam.Model.BillExportProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BEProductDetailsReps extends JpaRepository<BillExportProductDetails,Integer> {
    List<BillExportProductDetails> findAllByBillExportProduct(BillExportProduct billExportProduct);
}
