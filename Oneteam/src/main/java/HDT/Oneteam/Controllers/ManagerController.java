package HDT.Oneteam.Controllers;

import HDT.Oneteam.Model.Account;
import HDT.Oneteam.Model.Employee;
import HDT.Oneteam.Model.Position;
import HDT.Oneteam.Model.Role;
import HDT.Oneteam.Service.AccountService;
import HDT.Oneteam.Service.EmployeeService;
import HDT.Oneteam.Service.PositionService;
import HDT.Oneteam.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private RoleService roleService;
    @GetMapping("")
    public String admin(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        return "manager/index";
    }
    @GetMapping("/employee")
    public String employeeManager(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        List<Employee> employeeList = employeeService.getAllEmployeeByStatus(1);
        model.addAttribute("employeeList",employeeList);
        model.addAttribute("employee",true);
        return "manager/employeeManager";
    }
    @GetMapping("/employee/{id}")
    public String employeeManagerDetails(@PathVariable("id") int id, Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        Employee employeeDetails = employeeService.getEmployeeById(id);
        List<Position> positionList = positionService.getAllPosition();
        List<Role> roleList = roleService.getAllRole();
        model.addAttribute("edit",true);
        model.addAttribute("roleList",roleList);
        model.addAttribute("positionList",positionList);
        model.addAttribute("employeeDetails",employeeDetails);
        model.addAttribute("employee",true);
        return "manager/employeeDetails";
    }
    @GetMapping("/employee/create")
    public String createEmployee(Model model, Principal principal){
        if(principal != null){
            Account account = accountService.getAccountByName(principal.getName());
            model.addAttribute("account",account);
        }
        List<Position> positionList = positionService.getAllPosition();
        List<Role> roleList = roleService.getAllRole();
        model.addAttribute("roleList",roleList);
        model.addAttribute("positionList",positionList);
        model.addAttribute("employeeDetails",new Employee());
        model.addAttribute("employee",true);
        return "manager/employeeDetails";
    }
}
