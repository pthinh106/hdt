package HDT.Oneteam.API;

import HDT.Oneteam.Model.Account;
import HDT.Oneteam.Model.Contract;
import HDT.Oneteam.Model.Employee;
import HDT.Oneteam.Service.AccountService;
import HDT.Oneteam.Service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(path = "/sales/api")
public class RestApiSalesController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private AccountService accountService;

    @PostMapping("/liquidation")
    public ResponseEntity<Boolean> liquidationContract(@Param("listIdContract") String listIdContract){
        if(contractService.liquidationContract(listIdContract)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
    @PostMapping("/liquidationdontaccept")
    public ResponseEntity<Boolean> dontLiquidationContract(@Param("listIdContract") String listIdContract){
        if(contractService.liquidationContractDontAccept(listIdContract)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
    @PostMapping("/contract/create")
    public ResponseEntity<Boolean> createContract(@ModelAttribute("contracts") Contract contract,
                                                  @Param("productDetailsId") int[] productDetailsId, @Param("productQuantity") int[] productQuantity, @Param("accountId") int accountId){

        if(contractService.createContract(contract,productDetailsId,productQuantity,accountId)){
           return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
    @PostMapping("/contract/update")
    public ResponseEntity<Boolean> updateContract(@ModelAttribute("contracts") Contract contract,
                                                  @Param("productDetailsId") int[] productDetailsId, @Param("productQuantity") int[] productQuantity, @Param("accountId") int accountId){

        if(contractService.updateContract(contract,productDetailsId,productQuantity,accountId)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
    @PostMapping("/contract/delete/{id}")
    public ResponseEntity<Boolean> deleteContract(@PathVariable("id") int contractId){

        if(contractService.deletecontract(contractId)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
}
