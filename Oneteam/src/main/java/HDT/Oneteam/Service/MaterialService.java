package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Material;
import HDT.Oneteam.Repository.MaterialReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {
    @Autowired
    private MaterialReps materialReps;

    ///module
    public List<Material> getAllMaterial(){
        return materialReps.findAll();
    }
    public List<Material> getAllMaterialOn(int status){
        return materialReps.findAllByStatus(status);
    }
    public Material getMaterialById(int materialId){
        return materialReps.findById(materialId).get();
    }
    public void Save(Material material){
        materialReps.save(material);
    }
    public void saveAll(List<Material> materialList){
        materialReps.saveAll(materialList);
    }

    public boolean deleteMaterial(int id) {
        Optional<Material> material = materialReps.findById(id);
        if(material.isPresent()){
            material.get().setStatus(0);
            materialReps.save(material.get());
            return true;
        }
        return false;
    }

    public boolean createMaterial(Material materialDetails) {
        Optional<Material> material = materialReps.findById(materialDetails.getMaterialId());
        if(material.isPresent()){
            material.get().setInventory(materialDetails.getInventory());
            material.get().setMaterialName(materialDetails.getMaterialName());
            material.get().setUnit(materialDetails.getUnit());
            material.get().setPrice(materialDetails.getPrice());
            materialReps.save(material.get());
            return true;
        }else{
            materialDetails.setStatus(1);
            materialReps.save(materialDetails);
            return true;
        }
    }
}
