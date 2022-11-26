package HDT.Oneteam.Responsibility;

import HDT.Oneteam.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountReps extends JpaRepository<Account,Integer> {
    Boolean existsByUserName(String Username);
    Account findByUserName(String Username);
}
