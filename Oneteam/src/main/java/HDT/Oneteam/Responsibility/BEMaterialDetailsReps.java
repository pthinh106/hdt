package HDT.Oneteam.Responsibility;

import HDT.Oneteam.Model.BillExportMaterial;
import HDT.Oneteam.Model.BillExportMaterialDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BEMaterialDetailsReps extends JpaRepository<BillExportMaterialDetails,Integer> {
    List<BillExportMaterialDetails> findAllByBillExportMaterial(BillExportMaterial billImportMaterial);
}
