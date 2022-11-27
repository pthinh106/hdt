package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Contract;
import HDT.Oneteam.Responsibility.ContractReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    private ContractReps contractReps;


    ///module
    public List<Contract> getContractByStatus(int status){
        return contractReps.findAllByStatus(status);
    }
}
