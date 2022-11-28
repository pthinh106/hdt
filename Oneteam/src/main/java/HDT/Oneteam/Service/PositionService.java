package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Position;
import HDT.Oneteam.Responsibility.PositionReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {
    @Autowired
    private PositionReps positionReps;

    ///module
    public List<Position> getAllPosition(){
        return positionReps.findAll();
    }
}
