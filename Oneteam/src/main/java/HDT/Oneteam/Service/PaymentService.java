package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Payment;
import HDT.Oneteam.Repository.PaymentReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentReps paymentReps;


    ///module
    public List<Payment> getAllPayment(){
        return paymentReps.findAll();
    }
}
