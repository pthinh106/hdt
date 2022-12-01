package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Account;
import HDT.Oneteam.Model.Employee;
import HDT.Oneteam.Repository.EmployeeReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    private EmployeeReps employeeReps;
    @Autowired
    private AccountService accountService;

    ///module
    public Employee getEmployeeById(int employeeId){
        return employeeReps.findById(employeeId).get();
    }
    public Employee getEmployeeByAccountId(int accountId){
        return employeeReps.findByAccount(accountService.getAccountById(accountId));
    }
    public List<Employee> getAllEmployeeByStatus(int status){
        return employeeReps.findAllByStatus(status);
    }
    public boolean deleteEmployeeById(int employeeId){
        Optional<Employee> employee = employeeReps.findById(employeeId);
        if(employee.isPresent()){
            employee.get().setStatus(0);
            Account account = accountService.getAccountById(employee.get().getAccount().getAccountId());
            account.setStatus(0);
            employee.get().setAccount(accountService.saveNewAccount(account));
            employeeReps.save(employee.get());
            return true;
        }else{
            return false;
        }
    }
    public boolean CUEmployee(Employee employeeDetails){
        if(employeeDetails.getEmployeeName().isEmpty() || employeeDetails.getAddress().isEmpty() ||employeeDetails.getPhoneNumber().isEmpty() ||
        employeeDetails.getAccount().getUserName().isEmpty()){
            return false;
        }
        Optional<Employee> employee = employeeReps.findById(employeeDetails.getEmployeeId());
        if(!employee.isPresent()){
            if(accountService.existsAccountByUsername(employeeDetails.getAccount().getUserName())){
                return false;
            }else{
                Account account = accountService.saveNewAccount(employeeDetails.getAccount());
                employeeDetails.setAccount(account);
                employeeDetails.getAccount().setPassWord(passwordEncoder.encode(employeeDetails.getAccount().getPassWord()));
                employeeDetails.setStatus(1);
                try {
                    employeeReps.save(employeeDetails);
                    return true;
                }catch (Exception e) {
                    return false;
                }
            }
        }else{
                employee.get().setEmployeeName(employeeDetails.getEmployeeName());
                employee.get().setPosition(employeeDetails.getPosition());
                employee.get().setAddress(employeeDetails.getAddress());
                employee.get().setPhoneNumber(employeeDetails.getPhoneNumber());
                if(!employee.get().getAccount().getPassWord().equals(employeeDetails.getAccount().getPassWord())){
                    employeeDetails.getAccount().setPassWord(passwordEncoder.encode(employeeDetails.getAccount().getPassWord()));
                }
                employee.get().setAccount(accountService.saveNewAccount(employeeDetails.getAccount()));
                employee.get().setStatus(1);
                try {
                    employeeReps.save(employee.get());
                    return true;
                }catch (Exception e){
                    return false;
                }
        }
    }

}
