package HDT.Oneteam.Repository;

import HDT.Oneteam.Model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ContractReps extends JpaRepository<Contract,Integer> {
    List<Contract> findAllByStatus(int status);
    List<Contract> findAllByStatusOrderByUpdatedAsc(int status);
    List<Contract> findAllByStatusAndLiquidationStatusInOrderByUpdatedAsc(int status, Collection<Integer> liquidationStatus);
    List<Contract> findAllByStatusAndLiquidationStatus(int status,int liquidationStatus);
    List<Contract> findAllByContractIdIn(Collection<Integer> listContractId);
}
