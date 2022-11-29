package HDT.Oneteam.Service;

import HDT.Oneteam.Model.*;
import HDT.Oneteam.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillProductService {
    @Autowired
    private BExportProductReps bExportProductReps;
    @Autowired
    private BEProductDetailsReps beProductDetailsReps;


    @Autowired
    private BIProductDetailsReps biProductDetailsReps;
    @Autowired
    private BImportProductReps bImportProductReps;
    @Autowired
    private ContractService contractService;



    ///module import
    public List<BillImportProduct> getAllBIProductOnStatus(int status){
        return bImportProductReps.findAllByStatusOrderByCreatedAsc(status);
    }
    public BillImportProduct getBillImportProductById(int id){
        return bImportProductReps.findById(id).get();
    }
    public List<BillImportProductDetails> getBIProductDetailsByBIPId(BillImportProduct billImportProduct){
        return biProductDetailsReps.findAllByBillImportProduct(billImportProduct);
    }


    ///module export
    public List<BillExportProduct> getAllBEProductOnStatus(int status){
        return bExportProductReps.findAllByStatusOrderByCreatedAsc(status);
    }
    public BillExportProduct getBillExportProductById(int id){
        return bExportProductReps.findById(id).get();
    }
    public List<BillExportProductDetails> getBEProductDetailsByBEPId(BillExportProduct billExportProduct){
        return beProductDetailsReps.findAllByBillExportProduct(billExportProduct);
    }

    public boolean deleteProductImport(int id) {
        Optional<BillImportProduct> billImportProduct = bImportProductReps.findById(id);
        if(billImportProduct.isPresent()){
            billImportProduct.get().setStatus(0);
            bImportProductReps.save(billImportProduct.get());
            return true;
        }
        return false;
    }

    public boolean deleteProductExport(int id) {
        Optional<BillExportProduct> billExportProduct = bExportProductReps.findById(id);
        if(billExportProduct.isPresent()){
            billExportProduct.get().setStatus(0);
            bExportProductReps.save(billExportProduct.get());
            return true;
        }
        return false;
    }
}
