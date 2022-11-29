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

    public boolean deleteMaterial(int id) {
        Optional<Material> material = materialReps.findById(id);
        if(material.isPresent()){
            material.get().setStatus(0);
            materialReps.save(material.get());
            return true;
        }
        return false;
    }
}
