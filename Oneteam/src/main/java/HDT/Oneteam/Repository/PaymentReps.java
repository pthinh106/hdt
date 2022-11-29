package HDT.Oneteam.Repository;

import HDT.Oneteam.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentReps extends JpaRepository<Payment,Integer> {
}
