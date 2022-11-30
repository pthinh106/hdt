package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Workshop;
import HDT.Oneteam.Repository.WorkshopReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkshopService {
    @Autowired
    private WorkshopReps workshopReps;
    public List<Workshop> getAllWorkshop(){
        return workshopReps.findAll();
    }
}
