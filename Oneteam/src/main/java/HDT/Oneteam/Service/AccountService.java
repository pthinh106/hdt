package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Account;
import HDT.Oneteam.Repository.AccountReps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    AccountReps accountReps;
    public Account getAccountByName(String userName){
        return accountReps.findByUserName(userName);
    }
    public Account getAccountById(int accountId){
        return accountReps.findById(accountId).get();
    }
    public boolean existsAccountByUsername(String username){
        return accountReps.existsByUserName(username);
    }
    public Account saveNewAccount(Account account){
        return accountReps.save(account);
    }
}
