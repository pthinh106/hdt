package HDT.Oneteam.Controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class HandleErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request , Principal principal, Model model) {
        return "error";
    }

}
