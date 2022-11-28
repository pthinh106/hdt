package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Employee;
import HDT.Oneteam.Responsibility.AccountReps;
import HDT.Oneteam.Responsibility.EmployeeReps;
import HDT.Oneteam.Responsibility.PositionReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeReps employeeReps;

    ///module
    public Employee getEmployeeById(int employeeId){
        return employeeReps.findById(employeeId).get();
    }
    public List<Employee> getAllEmployee(){
        return employeeReps.findAll();
    }

}
