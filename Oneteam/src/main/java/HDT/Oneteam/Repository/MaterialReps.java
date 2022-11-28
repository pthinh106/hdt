package HDT.Oneteam.Repository;

import HDT.Oneteam.Model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialReps extends JpaRepository<Material,Integer> {
    List<Material> findAllByStatus(int status);
}
