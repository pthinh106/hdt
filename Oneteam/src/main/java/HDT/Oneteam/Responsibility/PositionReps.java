package HDT.Oneteam.Responsibility;

import HDT.Oneteam.Model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionReps extends JpaRepository<Position,Integer> {
}
