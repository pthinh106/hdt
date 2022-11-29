package HDT.Oneteam.Repository;

import HDT.Oneteam.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerReps extends JpaRepository<Customer,Integer> {
}
