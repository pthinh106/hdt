package HDT.Oneteam.Responsibility;

import HDT.Oneteam.Model.BillImportMaterial;
import HDT.Oneteam.Model.BillImportMaterialDetails;
import HDT.Oneteam.Model.BillImportProduct;
import HDT.Oneteam.Model.BillImportProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BIProductDetailsReps extends JpaRepository<BillImportProductDetails,Integer> {
    List<BillImportProductDetails> findAllByBillImportProduct(BillImportProduct billImportProduct);
}
