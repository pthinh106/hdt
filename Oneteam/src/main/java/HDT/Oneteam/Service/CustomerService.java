package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Customer;
import HDT.Oneteam.Repository.CustomerReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerReps customerReps;

    ///module

    public Customer getCustomerById(int customerId){
        return customerReps.findById(customerId).get();
    }
    public void save(Customer customer){
        customerReps.save(customer);
    }
}
