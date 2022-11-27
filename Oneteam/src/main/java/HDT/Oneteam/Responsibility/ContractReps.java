package HDT.Oneteam.Responsibility;

import HDT.Oneteam.Model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractReps extends JpaRepository<Contract,Integer> {
    List<Contract> findAllByStatus(int status);
}
