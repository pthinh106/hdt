package HDT.Oneteam.Service;

import HDT.Oneteam.Model.*;
import HDT.Oneteam.Repository.BEMaterialDetailsReps;
import HDT.Oneteam.Repository.BExportMaterialReps;
import HDT.Oneteam.Repository.BIMaterialDetailsReps;
import HDT.Oneteam.Repository.BImportMaterialReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private MaterialService materialService;



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

    public boolean createBillImportMaterial(BillImportMaterial billImportMaterial, int[] materialId, int[] quantity) {
        if(quantity.length < 1){
            return false;
        }
        billImportMaterial.setStatus(1);
        try {
            bImportMaterialReps.save(billImportMaterial);
        }catch (Exception e){
            return false;
        }

        double total = 0;
        for(int i = 0; i<quantity.length;i++){
            Material material = new Material();
            material = materialService.getMaterialById(materialId[i]);
            material.setInventory(material.getInventory()+quantity[i]);
            try {
                materialService.Save(material);
            }catch (Exception e){
                return false;
            }

            BillImportMaterialDetails billImportMaterialDetails = new BillImportMaterialDetails();
            billImportMaterialDetails.setBillImportMaterial(billImportMaterial);
            billImportMaterialDetails.setMaterial(material);
            billImportMaterialDetails.setQuantity(quantity[i]);
            billImportMaterialDetails.setTotal(material.getPrice()*quantity[i]);
            total += material.getPrice()*quantity[i];
            try {
                biMaterialDetailsReps.save(billImportMaterialDetails);
            }catch (Exception e){
                return false;
            }
        }
        billImportMaterial.setTotal(total);
        try {
            bImportMaterialReps.save(billImportMaterial);
        }catch (Exception e){
            return false;
        }

        return true;
    }

    public boolean createBillExportMaterial(BillExportMaterial billExportMaterial, int[] materialId, int[] quantity) {
        billExportMaterial.setStatus(1);
        try {
            bExportMaterialReps.save(billExportMaterial);
        }catch (Exception e){
            return false;
        }

        List<Material> materialList = new ArrayList<>();
        for(int i = 0 ; i < quantity.length;i++){
            Material material = new Material();
            material = materialService.getMaterialById(materialId[i]);
            if(material.getInventory() >= quantity[i]){
                material.setInventory(material.getInventory() - quantity[i]);
            }else{
                return false;
            }
            materialList.add(material);
            BillExportMaterialDetails billExportMaterialDetails = new BillExportMaterialDetails();
            billExportMaterialDetails.setBillExportMaterial(billExportMaterial);
            billExportMaterialDetails.setMaterial(material);
            billExportMaterialDetails.setQuantity(quantity[i]);
            try {
                bEMaterialDetailsReps.save(billExportMaterialDetails);
            }catch (Exception e){
                return false;
            }

        }
        try {
            materialService.saveAll(materialList);
        }catch (Exception e){
            return false;
        }

        return true;
    }
}
