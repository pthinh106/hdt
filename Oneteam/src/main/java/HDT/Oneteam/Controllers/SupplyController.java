package HDT.Oneteam.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/supply")
public class SupplyController {
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("dashboard",true);
        return "Supply/index";
    }
    @GetMapping("/warehouse")
    public String warehouse(Model model){
        model.addAttribute("warehouse",true);
        return "Supply/warehouse";
    }
    @GetMapping("/warehouse/product/create")
    public String createProduct(Model model){
        model.addAttribute("warehouse",true);
        return "Supply/addProduct";
    }
    @GetMapping("/warehouse/material/create")
    public String createMaterial(Model model){
        model.addAttribute("warehouse",true);
        return "Supply/addIngredient";
    }
    @GetMapping("/ingredient")
    public String ingredient(Model model){
        model.addAttribute("ingredient",true);
        return "Supply/ingredient";
    }
    @GetMapping("/ingredient/bill/create")
    public String createIngredient(Model model){
        model.addAttribute("ingredient",true);
        return "Supply/addBillMaterial";
    }
}
