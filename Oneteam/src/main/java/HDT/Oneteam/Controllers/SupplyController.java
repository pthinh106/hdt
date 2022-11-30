package HDT.Oneteam.Controllers;

import HDT.Oneteam.Model.*;
import HDT.Oneteam.Repository.ProductStructReps;
import HDT.Oneteam.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(path = "/supply")
public class SupplyController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private ProductService productService;
    @Autowired
    private MaterialService materialService;
    @Autowired
    private BillMaterialService billMaterialService;
    @Autowired
    private BillProductService billProductService;
    @Autowired
    private WorkshopService workshopService;
    @Autowired
    private ProductStructService productStructService;


    @GetMapping("")
    public String index(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        Collection<Integer> liquidation = new ArrayList<>();
        liquidation.add(0);
        liquidation.add(1);
        List<Contract> contractList = contractService.getContractByStatusAndLiquidationStatusIn(0,liquidation);
        model.addAttribute("contractList",contractList);
        model.addAttribute("dashboardSupply",true);
        model.addAttribute("importProduct",billProductService.getAllBIProductOnStatus(1));
        model.addAttribute("exportProduct",billProductService.getAllBEProductOnStatus(1));
        model.addAttribute("importMaterial",billMaterialService.getAllBIMaterialOnStatus(1));
        model.addAttribute("exportMaterial",billMaterialService.getAllBEMaterialOnStatus(1));
        return "Supply/index";
    }
    @GetMapping("/contract/{id}")
    public String getContractDetails(@PathVariable("id") int id,Model model,Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        double total = 0 ;
        Contract contracts = contractService.getContractById(id);
        List<ContractDetails> contractDetailsList = contractService.getListContractDetailsByContract(contracts);
        for(ContractDetails contractDetails : contractDetailsList){
            total = total + contractDetails.getProduct().getPrice()*contractDetails.getQuantity();
        }
        model.addAttribute("total",total);
        model.addAttribute("contracts",contracts);
        model.addAttribute("contractDetailsList",contractDetailsList);
        model.addAttribute("dashboardSupply",true);
        return "Supply/contractDetails";
    }
    ///Warehouse
    @GetMapping("/warehouse")
    public String warehouse(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        List<Product> productList = productService.getAllProductOn(1);
        List<Material> materialList = materialService.getAllMaterialOn(1);
        model.addAttribute("productList",productList);
        model.addAttribute("materialList",materialList);
        model.addAttribute("warehouse",true);
        return "Supply/warehouse";
    }
    @GetMapping("/warehouse/product/create")
    public String createProduct(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        List<ProductStructure> productStructureList = new ArrayList<>();
        productStructureList.add(new ProductStructure());
        Product product = new Product();
        product.setProductStructureList(productStructureList);
        model.addAttribute("product",product);
        model.addAttribute("materialList1",materialService.getAllMaterialOn(1));
        model.addAttribute("warehouse",true);
        return "Supply/addProduct";
    }
    @GetMapping("/warehouse/product/{id}")
    public String createProduct(@PathVariable("id") int id,Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        Product product = productService.getProductById(id);
        model.addAttribute("product",product);
        model.addAttribute("productStructList",productStructService.getStructProduct(product));
        model.addAttribute("warehouse",true);
        return "Supply/productStruct";
    }
    @GetMapping("/warehouse/product/update/{id}")
    public String updateProduct(@PathVariable("id") int id,Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        Product product = productService.getProductById(id);
        System.out.println(product.toString());
        model.addAttribute("product",product);
        model.addAttribute("productStructList",productStructService.getStructProduct(product));
        model.addAttribute("materialList1",materialService.getAllMaterialOn(1));
        return "Supply/updateProduct";
    }
    @GetMapping("/warehouse/material/create")
    public String createMaterial(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        model.addAttribute("material",new Material());
        model.addAttribute("warehouse",true);
        return "Supply/addMaterial";
    }
    @GetMapping("/warehouse/material/update/{id}")
    public String UpdateMaterial(@PathVariable("id") int id,Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        model.addAttribute("material",materialService.getMaterialById(id));
        model.addAttribute("warehouse",true);
        return "Supply/addMaterial";
    }

    /// Bill Material
    @GetMapping("/billimportmatertial")
    public String billImportMaterial(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        List<BillImportMaterial> billImportMaterialList = billMaterialService.getAllBIMaterialOnStatus(1);
        model.addAttribute("billImportMaterialList",billImportMaterialList);
        model.addAttribute("ingredientImport",true);
        return "Supply/billImportMaterial";
    }
    @GetMapping("/billimportmatertial/{id}")
    public String billImportMaterialDetails(@PathVariable("id") int id, Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        BillImportMaterial billImportMaterial = billMaterialService.getBillImportMaterialById(id);
        List<BillImportMaterialDetails> BIMaterialDetails = billMaterialService.getBIMaterialDetailsByBIMId(billImportMaterial);
        double total = 0;
        for(BillImportMaterialDetails biMaterialDetails : BIMaterialDetails){
            total = total + biMaterialDetails.getMaterial().getPrice() * biMaterialDetails.getQuantity();
        }
        Contract contracts = contractService.getContractById(billImportMaterial.getContract().getContractId());
        model.addAttribute("contracts",contracts);
        model.addAttribute("billImportMaterial",billImportMaterial);
        model.addAttribute("total",total);
        model.addAttribute("BIMaterialDetails",BIMaterialDetails);
        model.addAttribute("ingredientImport",true);
        return "Supply/billImportMaterialDetails";
    }
    @GetMapping("/importmatertial/bill/create")
    public String createBillImportMaterial(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        model.addAttribute("billImportMaterial",new BillImportMaterial());
        model.addAttribute("contractList",contractService.getContractByStatus(0));
        model.addAttribute("materialList",materialService.getAllMaterialOn(1));
        model.addAttribute("ingredientImport",true);
        return "Supply/addBillImportMaterial";
    }
    @GetMapping("/billexportmatertial")
    public String billExportMaterial(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        List<BillExportMaterial> billExportMaterialList = billMaterialService.getAllBEMaterialOnStatus(1);
        model.addAttribute("billExportMaterialList",billExportMaterialList);
        model.addAttribute("ingredientExport",true);
        return "Supply/billExportMaterial";
    }
    @GetMapping("/billexportmatertial/{id}")
    public String billExportMaterialDetails(@PathVariable("id") int id, Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        BillExportMaterial billExportMaterial = billMaterialService.getBillExportMaterialById(id);
        List<BillExportMaterialDetails> bEDetailsList = billMaterialService.getBEMaterialDetailsByBEMId(billExportMaterial);
        model.addAttribute("billExportMaterial",billExportMaterial);
        model.addAttribute("bEDetailsList",bEDetailsList);
        model.addAttribute("ingredientExport",true);
        return "Supply/billExportMaterialDetails";
    }
    @GetMapping("/exportmatertial/bill/create")
    public String createBillExportMaterial(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        model.addAttribute("billExportMaterial",new BillExportMaterial());
        model.addAttribute("workshopList",workshopService.getAllWorkshop());
        model.addAttribute("materialList",materialService.getAllMaterialOn(1));
        model.addAttribute("ingredientExport",true);
        return "Supply/addBillExportMaterial";
    }


    /// Bill Product
    @GetMapping("/billimportproduct")
    public String billimportProduct(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        List<BillImportProduct> billImportProductList = billProductService.getAllBIProductOnStatus(1);
        model.addAttribute("billImportProductList",billImportProductList);
        model.addAttribute("productImport",true);
        return "Supply/billImportProduct";
    }
    @GetMapping("/billimportproduct/{id}")
    public String billimportProductDetails(@PathVariable("id") int id,Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        BillImportProduct billImportProduct = billProductService.getBillImportProductById(id);
        List<BillImportProductDetails> bEDetailsList = billProductService.getBIProductDetailsByBIPId(billImportProduct);
        model.addAttribute("billImportProduct",billImportProduct);
        model.addAttribute("bEDetailsList",bEDetailsList);
        model.addAttribute("productImport",true);
        return "Supply/billImportProductDetails";
    }
    @GetMapping("/importproduct/bill/create")
    public String createBillImportProduct(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        model.addAttribute("billImportProduct",new BillImportProduct());
        model.addAttribute("workshopList",workshopService.getAllWorkshop());
        model.addAttribute("productList",productService.getAllProductOn(1));
        model.addAttribute("productImport",true);
        return "Supply/addBillImportProduct";
    }
    @GetMapping("/billexportproduct")
    public String billExportProduct(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        List<BillExportProduct> billExportProductList = billProductService.getAllBEProductOnStatus(1);
        model.addAttribute("billExportProductList",billExportProductList);
        model.addAttribute("productExport",true);
        return "Supply/billExportProduct";
    }
    @GetMapping("/billexportproduct/{id}")
    public String billExportProductDetails(@PathVariable("id") int id,Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }

        double total = 0;
        BillExportProduct billExportProduct = billProductService.getBillExportProductById(id);
        List<BillExportProductDetails> bEDetailsList = billProductService.getBEProductDetailsByBEPId(billExportProduct);
        for(BillExportProductDetails billExportProductDetails : bEDetailsList){
            total = total + billExportProductDetails.getProduct().getPrice() * billExportProductDetails.getQuantity();
        }
        Contract contracts = contractService.getContractById(billExportProduct.getContract().getContractId());
        model.addAttribute("contracts",contracts);
        model.addAttribute("billExportProduct",billExportProduct);
        model.addAttribute("bEDetailsList",bEDetailsList);
        model.addAttribute("total",total);
        model.addAttribute("productExport",true);
        return "Supply/billExportProductDetails";
    }
//    @GetMapping("/exportproduct/bill/create")
//    public String createBillExportProduct(Model model, Principal principal){
//        if(principal != null){
//            Account account = accountService.getAccountByName(principal.getName());
//            model.addAttribute("account",account);
//        }
//        model.addAttribute("productExport",true);;
//        return "Supply/addBillExportProduct";
//    }


}
