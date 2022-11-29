package HDT.Oneteam.Service;

import HDT.Oneteam.Model.BillExportMaterial;
import HDT.Oneteam.Model.BillExportMaterialDetails;
import HDT.Oneteam.Model.BillImportMaterial;
import HDT.Oneteam.Model.BillImportMaterialDetails;
import HDT.Oneteam.Repository.BEMaterialDetailsReps;
import HDT.Oneteam.Repository.BExportMaterialReps;
import HDT.Oneteam.Repository.BIMaterialDetailsReps;
import HDT.Oneteam.Repository.BImportMaterialReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillMaterialService {
    @Autowired
    private BExportMaterialReps bExportMaterialReps;
    @Autowired
    private BEMaterialDetailsReps bEMaterialDetailsReps;


    @Autowired
    private BImportMaterialReps bImportMaterialReps;
    @Autowired
    private BIMaterialDetailsReps biMaterialDetailsReps;



    ///module import
    public List<BillImportMaterial> getAllBIMaterialOnStatus(int status){
        return bImportMaterialReps.findAllByStatusOrderByCreatedAsc(status);
    }
    public BillImportMaterial getBillImportMaterialById(int id){
        return bImportMaterialReps.findById(id).get();
    }
    public List<BillImportMaterialDetails> getBIMaterialDetailsByBIMId(BillImportMaterial billImportMaterial){
        return biMaterialDetailsReps.findAllByBillImportMaterial(billImportMaterial);
    }


    ///module export
    public List<BillExportMaterial> getAllBEMaterialOnStatus(int status){
        return bExportMaterialReps.findAllByStatusOrderByCreatedAsc(status);
    }
    public BillExportMaterial getBillExportMaterialById(int id){
        return bExportMaterialReps.findById(id).get();
    }
    public List<BillExportMaterialDetails> getBEMaterialDetailsByBEMId(BillExportMaterial billExportMaterial){
        return bEMaterialDetailsReps.findAllByBillExportMaterial(billExportMaterial);
    }

    public boolean deleteMaterialImport(int id) {

        Optional<BillImportMaterial> billImportMaterial = bImportMaterialReps.findById(id);
        if(billImportMaterial.isPresent()){
            billImportMaterial.get().setStatus(0);
            bImportMaterialReps.save(billImportMaterial.get());
            return true;
        }
        return false;
    }

    public boolean deleteMaterialExport(int id) {
        Optional<BillExportMaterial> billExportMaterial = bExportMaterialReps.findById(id);
        if(billExportMaterial.isPresent()){
            billExportMaterial.get().setStatus(0);
            bExportMaterialReps.save(billExportMaterial.get());
            return true;
        }
        return false;
    }
}
