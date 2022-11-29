package HDT.Oneteam.API;

import HDT.Oneteam.Service.*;
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
    @Autowired
    private MaterialService materialService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BillProductService billProductService;
    @Autowired
    private BillMaterialService billMaterialService;
    @PostMapping("/liquidationrequest/{id}")
    public ResponseEntity<Boolean> liquidationRequest(@PathVariable("id") int id){
        if(contractService.liquidationRequest(id)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
    @PostMapping("/material/delete/{id}")
    public ResponseEntity<Boolean> deleteMaterial(@PathVariable("id") int id){
        if(materialService.deleteMaterial(id)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
    @PostMapping("/product/delete/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") int id){
        if(productService.deleteProduct(id)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
    @PostMapping("/materialimport/delete/{id}")
    public ResponseEntity<Boolean> deleteMaterialImport(@PathVariable("id") int id){
        if(billMaterialService.deleteMaterialImport(id)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
    @PostMapping("/productimport/delete/{id}")
    public ResponseEntity<Boolean> deleteProductImport(@PathVariable("id") int id){
        if(billProductService.deleteProductImport(id)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
    @PostMapping("/materialexport/delete/{id}")
    public ResponseEntity<Boolean> deleteMaterialExport(@PathVariable("id") int id){
        if(billMaterialService.deleteMaterialExport(id)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
    @PostMapping("/productexport/delete/{id}")
    public ResponseEntity<Boolean> deleteProductExport(@PathVariable("id") int id){
        if(billProductService.deleteProductExport(id)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
}

