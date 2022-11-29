package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Role;
import HDT.Oneteam.Repository.RoleReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleReps roleReps;

    //module
    public List<Role> getAllRole(){
        return roleReps.findAll();
    }
}
