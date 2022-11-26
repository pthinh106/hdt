package HDT.Oneteam.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/sales")
public class SalesController {
    @GetMapping("")
    public String index(){
        return "Sales/index";
    }
}
