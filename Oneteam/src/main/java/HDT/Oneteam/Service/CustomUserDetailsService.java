package HDT.Oneteam.Service;

import HDT.Oneteam.Model.Account;
import HDT.Oneteam.Responsibility.AccountReps;
import HDT.Oneteam.UserDetails.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    AccountReps accountReps;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        boolean exist = accountReps.existsByUserName(username);
        if(exist){
            Account account = accountReps.findByUserName(username);
            CustomUserDetails customUserDetails = new CustomUserDetails(account);
            return customUserDetails;
        }
        return null;
    }
}
