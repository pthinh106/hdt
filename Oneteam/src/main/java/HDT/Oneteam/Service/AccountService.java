package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Account;
import HDT.Oneteam.Responsibility.AccountReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountReps accountReps;
    public Account getAccountByName(String userName){
        return accountReps.findByUserName(userName);
    }
}
