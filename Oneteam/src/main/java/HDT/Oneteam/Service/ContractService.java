package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Contract;
import HDT.Oneteam.Model.ContractDetails;
import HDT.Oneteam.Model.Product;
import HDT.Oneteam.Repository.ContractDetailsReps;
import HDT.Oneteam.Repository.ContractReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class ContractService {
    @Autowired
    private ContractReps contractReps;
    @Autowired
    private ContractDetailsReps contractDetailsReps;
    @Autowired
    private ProductService productService;


    ///module
    public List<Contract> getContractByStatus(int status){
        return contractReps.findAllByStatus(status);
    }
    public List<Contract> getContractByStatusAndLiquidationStatusIn(int status, Collection<Integer> liquidationStatus){
        List<Contract> contractList = contractReps.findAllByStatusOrderByUpdatedAsc(0);
        for(Contract contract : contractList){
            if(contract.getLiquidationStatus() == 1 || contract.getLiquidationStatus() == 2){
                continue;
            }else{
                List<ContractDetails> contractDetailsList = contractDetailsReps.findAllByContract(contract);
                for(ContractDetails contractDetails : contractDetailsList){
                    if(contractDetails.getQuantity() > contractDetails.getProduct().getInventory()){
                        contract.setLiquidationStatus(0);
                        break;
                    }else{
                        contract.setLiquidationStatus(1);
                    }
                }
                if(contract.getLiquidationStatus() == 1){
                    for(ContractDetails contractDetails : contractDetailsList){
                        Product product = productService.getProductById(contractDetails.getProduct().getProductId());
                        product.setInventory(product.getInventory() - contractDetails.getQuantity());
                        productService.save(product);
                    }
                }else{
                    if(contract.getLiquidationStatus() == 0){
                        break;
                    }
                }
            }
        }
        contractReps.saveAll(contractList);

        return contractReps.findAllByStatusAndLiquidationStatusInOrderByUpdatedAsc(status,liquidationStatus);
    }
    public List<Contract> getContractByStatusAndLiquidationStatus(int status,int liquidationStatus){
        return contractReps.findAllByStatusAndLiquidationStatus(status,liquidationStatus);
    }

    public Contract getContractById(int contractId){
        return contractReps.findById(contractId).get();
    }
    public List<ContractDetails> getListContractDetailsByContract(Contract contract){
        return contractDetailsReps.findAllByContract(contract);
    }

    public Boolean liquidationRequest(int contractId){
        Optional<Contract> contract = contractReps.findById(contractId);
        if(contract.isPresent()){
            contract.get().setLiquidationStatus(2);
            contractReps.save(contract.get());
            return true;
        }else{
            return false;
        }
    }
    public Boolean liquidationContract(String listContractId){
        Collection<Integer> listContractIdCol = new ArrayList<>();
        String[] listId = listContractId.split(",");
        for(int i = 0 ; i < listId.length; i++){
            listContractIdCol.add(Integer.parseInt(listId[i]));
        }
        List<Contract> contractList = contractReps.findAllByContractIdIn(listContractIdCol);
        if(!contractList.isEmpty()){
            for(Contract contract : contractList){
                contract.setStatus(1);
            }
            contractReps.saveAll(contractList);
            return true;
        }
        return false;
    }
    public Boolean liquidationContractDontAccept(String listContractId){
        Collection<Integer> listContractIdCol = new ArrayList<>();
        String[] listId = listContractId.split(",");
        for(int i = 0 ; i < listId.length; i++){
            listContractIdCol.add(Integer.parseInt(listId[i]));
        }
        List<Contract> contractList = contractReps.findAllByContractIdIn(listContractIdCol);
        if(!contractList.isEmpty()){
            for(Contract contract : contractList){
                contract.setLiquidationStatus(1);
            }
            contractReps.saveAll(contractList);
            return true;
        }
        return false;
    }
}
