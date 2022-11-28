package HDT.Oneteam.API;
import HDT.Oneteam.Model.Employee;
import HDT.Oneteam.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/manager/api")
public class ApiRestManagerController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/employee")
    public ResponseEntity<Boolean> CUEmployee(@ModelAttribute("employeeDetails")Employee employee){
        System.out.println(employee);
        if(employeeService.CUEmployee(employee)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
    @PostMapping("/employee/delete/{id}")
    public ResponseEntity<Boolean> deletedEmployee(@PathVariable("id") int employeeId){
        if(employeeService.deleteEmployeeById(employeeId)){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.ok().body(false);
    }
}
