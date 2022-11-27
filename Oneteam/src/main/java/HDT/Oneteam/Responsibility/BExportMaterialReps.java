package HDT.Oneteam.Responsibility;

import HDT.Oneteam.Model.BillExportMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BExportMaterialReps extends JpaRepository<BillExportMaterial,Integer> {
    List<BillExportMaterial> findAllByStatusOrderByCreatedAsc(int status);
}
