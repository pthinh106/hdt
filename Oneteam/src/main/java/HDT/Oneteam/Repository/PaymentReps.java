package HDT.Oneteam.Repository;

import HDT.Oneteam.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentReps extends JpaRepository<Payment,Integer> {
}
