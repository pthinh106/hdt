package HDT.Oneteam.API;

import HDT.Oneteam.Service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/supply/api")
public class RestApiSupplyController {
    @Autowired
    private ContractService contractService;
    @PostMapping("/liquidationrequest/{id}")
    public ResponseEntity<Boolean> liquidationRequest(@PathVariable("id") int id){
        if(contractService.liquidationRequest(id)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
    @PostMapping("/material")
}
