package HDT.Oneteam.Controllers;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/sales")
public class SalesController {
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("dashboard",true);
        return "Sales/index";
    }
    @GetMapping("/contract")
    public String contact(Model model){
        model.addAttribute("contract",true);
        return "Sales/contract";
    }
    @GetMapping("/contract/{id}")
    public String getContractDetails(@PathVariable("id") int contractId, Model model){
        model.addAttribute("contract",true);
        return "Sales/contractDetails";
    }
    @GetMapping("/contract/create")
    public String createContract(Model model){
        model.addAttribute("contract",true);
        return "Sales/addContract";
    }
    @GetMapping("/liquidation")
    public String liquidationContact(Model model){
        model.addAttribute("liquidation",true);
        return "Sales/liquidation";
    }
}
