package HDT.Oneteam.Repository;

import HDT.Oneteam.Model.Contract;
import HDT.Oneteam.Model.ContractDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractDetailsReps extends JpaRepository<ContractDetails,Integer> {
    List<ContractDetails> findAllByContract(Contract contract);
}
