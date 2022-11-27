package HDT.Oneteam.Responsibility;

import HDT.Oneteam.Model.BillExportMaterialDetails;
import HDT.Oneteam.Model.BillImportMaterial;
import HDT.Oneteam.Model.BillImportMaterialDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BIMaterialDetailsReps extends JpaRepository<BillImportMaterialDetails,Integer> {
    List<BillImportMaterialDetails> findAllByBillImportMaterial(BillImportMaterial billImportMaterial);
}
