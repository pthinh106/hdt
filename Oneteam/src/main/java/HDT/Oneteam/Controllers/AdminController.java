package HDT.Oneteam.Controllers;

import HDT.Oneteam.Model.Account;
import HDT.Oneteam.Responsibility.AccountReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
@RequestMapping(path = "")
public class AdminController {
    @Autowired
    AccountReps accountReps;
    @GetMapping("/login")
    public String login(Principal principal, @Param("error") String error, Model model){
        if(principal != null){
            return "redirect:/admin";
        }
        if(error != null){
            model.addAttribute("error",true);
        }
        return "login";
    }
    @GetMapping("/")
    public String getURl(Principal principal){
        if(principal != null){
            Account account = accountReps.findByUserName(principal.getName());
            if(account.getRole().getRoleId() == 1){
                return "redirect:/supply";
            }
            if (account.getRole().getRoleId() == 2){
                return "redirect:/sales";
            }
        }
        return "redirect:/login";
    }
    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
    }
}
