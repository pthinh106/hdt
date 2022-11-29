package HDT.Oneteam.Repository;

import HDT.Oneteam.Model.Contract;
import HDT.Oneteam.Model.ContractDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractDetailsReps extends JpaRepository<ContractDetails,Integer> {
    List<ContractDetails> findAllByContract(Contract contract);
}
