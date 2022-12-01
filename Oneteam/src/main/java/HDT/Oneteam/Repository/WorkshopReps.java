package HDT.Oneteam.Repository;

import HDT.Oneteam.Model.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkshopReps extends JpaRepository<Workshop,Integer> {

}
