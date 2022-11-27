package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Material;
import HDT.Oneteam.Responsibility.MaterialReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
