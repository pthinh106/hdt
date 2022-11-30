package HDT.Oneteam.Controllers;

import HDT.Oneteam.Model.Account;
import HDT.Oneteam.Model.Contract;
import HDT.Oneteam.Model.ContractDetails;
import HDT.Oneteam.Model.Product;
import HDT.Oneteam.Service.AccountService;
import HDT.Oneteam.Service.ContractService;
import HDT.Oneteam.Service.PaymentService;
import HDT.Oneteam.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(path = "/sales")
public class SalesController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private ProductService productService;
    @GetMapping("")
    public String index(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        List<Contract> contractList = contractService.getContractByStatus(1);
        model.addAttribute("contractList",contractList);
        model.addAttribute("dashboardSales",true);
        model.addAttribute("allContract",contractService.getAll());
        model.addAttribute("processing",contractService.getContractByStatus(0));
        model.addAttribute("liquidated",contractService.getContractByStatus(1));
        model.addAttribute("cancel",contractService.getContractByStatus(3));


        return "Sales/index";
    }
    @GetMapping("/contract")
    public String contact(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        List<Contract> contractList = contractService.getContractByStatus(0);
        model.addAttribute("contractList",contractList);
        model.addAttribute("contract",true);
        return "Sales/contract";
    }
    @GetMapping("/contract/{id}")
    public String getContractDetails(@PathVariable("id") int contractId, Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        double total = 0 ;
        Contract contracts = contractService.getContractById(contractId);
        List<ContractDetails> contractDetailsList = contractService.getListContractDetailsByContract(contracts);
        for(ContractDetails contractDetails : contractDetailsList){
            total = total + contractDetails.getProduct().getPrice()*contractDetails.getQuantity();
        }
        model.addAttribute("total",total);
        model.addAttribute("contracts",contracts);
        model.addAttribute("contractDetailsList",contractDetailsList);
        model.addAttribute("contract",true);
        return "Sales/contractDetails";
    }
    @GetMapping("/contractsuccess/{id}")
    public String getContractDetailsSuccess(@PathVariable("id") int contractId, Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        double total = 0 ;
        Contract contracts = contractService.getContractById(contractId);
        List<ContractDetails> contractDetailsList = contractService.getListContractDetailsByContract(contracts);
        for(ContractDetails contractDetails : contractDetailsList){
            total = total + contractDetails.getProduct().getPrice()*contractDetails.getQuantity();
        }
        model.addAttribute("total",total);
        model.addAttribute("contracts",contracts);
        model.addAttribute("contractDetailsList",contractDetailsList);
        model.addAttribute("dashboardSales",true);
        return "Sales/contractDetails";
    }
    @GetMapping("/contractdelete/{id}")
    public String getContractDetailsDelete(@PathVariable("id") int contractId, Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        double total = 0 ;
        Contract contracts = contractService.getContractById(contractId);
        List<ContractDetails> contractDetailsList = contractService.getListContractDetailsByContract(contracts);
        for(ContractDetails contractDetails : contractDetailsList){
            total = total + contractDetails.getProduct().getPrice()*contractDetails.getQuantity();
        }
        model.addAttribute("total",total);
        model.addAttribute("contracts",contracts);
        model.addAttribute("contractDetailsList",contractDetailsList);
        model.addAttribute("dashboardSales",true);
        return "Sales/contractDetails";
    }
    @GetMapping("/contract/create")
    public String createContract(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        model.addAttribute("productList",productService.getAllProductOn(1));
        model.addAttribute("paymentList",paymentService.getAllPayment());
        model.addAttribute("contracts",new Contract());
        model.addAttribute("contract",true);
        return "Sales/addContract";
    }
    @GetMapping("/liquidation")
    public String liquidationContact(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        List<Contract> contractList = contractService.getContractByStatusAndLiquidationStatus(0,2);
        model.addAttribute("contractList",contractList);
        model.addAttribute("liquidation",true);
        return "Sales/liquidation";
    }
    @GetMapping("/liquidation/{id}")
    public String liquidationContactDetails(@PathVariable("id") int id, Model model, Principal principal){
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
        model.addAttribute("liquidation",true);
        return "Sales/contractDetails";
    }
}
