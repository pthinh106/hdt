package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Contract;
import HDT.Oneteam.Model.ContractDetails;
import HDT.Oneteam.Repository.ContractDetailsReps;
import HDT.Oneteam.Repository.ContractReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    private ContractReps contractReps;
    @Autowired
    private ContractDetailsReps contractDetailsReps;


    ///module
    public List<Contract> getContractByStatus(int status){
        return contractReps.findAllByStatus(status);
    }
    public Contract getContractById(int contractId){
        return contractReps.findById(contractId).get();
    }
    public List<ContractDetails> getListContractDetailsByContract(Contract contract){
        return contractDetailsReps.findAllByContract(contract);
    }
}
