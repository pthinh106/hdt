package HDT.Oneteam.Responsibility;

import HDT.Oneteam.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeReps extends JpaRepository<Employee,Integer> {
}
