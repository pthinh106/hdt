package HDT.Oneteam.API;

import HDT.Oneteam.Model.*;
import HDT.Oneteam.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/material/create")
    public ResponseEntity<Boolean> createMaterial(@ModelAttribute("material")Material material){
        System.out.println(material.getMaterialId());
        if(materialService.createMaterial(material)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
    @PostMapping("/material/bill/import")
    public ResponseEntity<Boolean> createBillImportMaterial(@ModelAttribute("billImportMaterial") BillImportMaterial billImportMaterial,
                                                            @RequestParam("materialId") int[] materialId,@RequestParam("quantity") int[] quantity){
        System.out.println(billImportMaterial.toString());
        if(billMaterialService.createBillImportMaterial(billImportMaterial,materialId,quantity)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
    @PostMapping("/material/bill/export")
    public ResponseEntity<Boolean> createBillExportMaterial(@ModelAttribute("billExportMaterial") BillExportMaterial billExportMaterial,
                                                            @RequestParam("materialId") int[] materialId,@RequestParam("quantity") int[] quantity){
        System.out.println(billExportMaterial.toString());
        if(billMaterialService.createBillExportMaterial(billExportMaterial,materialId,quantity)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
    @PostMapping("/product/bill/import")
    public ResponseEntity<Boolean> createBillImportProduct(@ModelAttribute("billImportProduct") BillImportProduct billImportProduct,
                                                            @RequestParam("productId") int[] productId,@RequestParam("quantity") int[] quantity){
        System.out.println(billImportProduct.toString());
        if(billProductService.createBillImportProduct(billImportProduct,productId,quantity)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
    @PostMapping("/product/create")
    public ResponseEntity<Boolean> createProduct(@ModelAttribute("product") Product product,
                                                           @RequestParam("materialId") int[] materialId,@RequestParam("quantity") int[] quantity){
        System.out.println(product.toString());
        if(productService.createProduct(product,materialId,quantity)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
}

