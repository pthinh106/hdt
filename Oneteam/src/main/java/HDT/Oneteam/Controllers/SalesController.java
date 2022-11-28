package HDT.Oneteam.Controllers;

import HDT.Oneteam.Model.Account;
import HDT.Oneteam.Model.Contract;
import HDT.Oneteam.Service.AccountService;
import HDT.Oneteam.Service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(path = "/sales")
public class SalesController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private ContractService contractService;
    @GetMapping("")
    public String index(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        model.addAttribute("dashboardSales",true);
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
        model.addAttribute("contract",true);
        return "Sales/contractDetails";
    }
    @GetMapping("/contract/create")
    public String createContract(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        model.addAttribute("contract",true);
        return "Sales/addContract";
    }
    @GetMapping("/liquidation")
    public String liquidationContact(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        List<Contract> contractList = contractService.getContractByStatus(0);
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
        List<Contract> contractList = contractService.getContractByStatus(0);
        model.addAttribute("contractList",contractList);
        model.addAttribute("liquidation",true);
        return "Sales/contractDetails";
    }
}
