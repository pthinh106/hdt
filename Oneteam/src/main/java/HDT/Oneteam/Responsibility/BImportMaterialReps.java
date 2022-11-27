package HDT.Oneteam.Responsibility;

import HDT.Oneteam.Model.BillImportMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BImportMaterialReps extends JpaRepository<BillImportMaterial,Integer> {
    List<BillImportMaterial> findAllByStatusOrderByCreatedAsc(int status);
}
