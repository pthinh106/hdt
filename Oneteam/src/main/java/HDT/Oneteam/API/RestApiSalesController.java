package HDT.Oneteam.API;

import HDT.Oneteam.Service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sales/api")
public class RestApiSalesController {
    @Autowired
    private ContractService contractService;

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
}
