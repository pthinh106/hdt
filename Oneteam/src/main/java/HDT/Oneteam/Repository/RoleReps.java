package HDT.Oneteam.Repository;

import HDT.Oneteam.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleReps extends JpaRepository<Role,Integer> {
}
