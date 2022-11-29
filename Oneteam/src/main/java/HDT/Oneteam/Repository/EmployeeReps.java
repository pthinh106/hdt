package HDT.Oneteam.Repository;

import HDT.Oneteam.Model.Account;
import HDT.Oneteam.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeReps extends JpaRepository<Employee,Integer> {
    List<Employee> findAllByStatus(int status);
    Employee findByAccount(Account account);
}
