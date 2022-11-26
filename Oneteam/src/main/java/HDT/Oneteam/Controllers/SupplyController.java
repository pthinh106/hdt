package HDT.Oneteam.Controllers;

import HDT.Oneteam.Model.Account;
import HDT.Oneteam.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping(path = "/supply")
public class SupplyController {
    @Autowired
    AccountService accountService;
    @GetMapping("")
    public String index(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        model.addAttribute("dashboard",true);
        return "Supply/index";
    }
    @GetMapping("/warehouse")
    public String warehouse(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        model.addAttribute("warehouse",true);
        return "Supply/warehouse";
    }
    @GetMapping("/warehouse/product/create")
    public String createProduct(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        model.addAttribute("warehouse",true);
        return "Supply/addProduct";
    }
    @GetMapping("/warehouse/material/create")
    public String createMaterial(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        model.addAttribute("warehouse",true);
        return "Supply/addIngredient";
    }
    @GetMapping("/ingredient")
    public String ingredient(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        model.addAttribute("ingredient",true);
        return "Supply/ingredient";
    }
    @GetMapping("/ingredient/bill/create")
    public String createIngredient(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        model.addAttribute("ingredient",true);
        return "Supply/addBillMaterial";
    }
}
