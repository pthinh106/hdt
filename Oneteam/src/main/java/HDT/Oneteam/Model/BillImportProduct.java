package HDT.Oneteam.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "phieunhapsp")
public class BillImportProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAPNNL")
    private int billImportId;
    @ManyToOne
    @JoinColumn(name = "MAPX")
    private Workshop workshop;
    @Column(name = "NGAYNHAP")
    private Timestamp created;

    public BillImportProduct(){}

    public BillImportProduct(int billImportId, Workshop workshop) {
        this.billImportId = billImportId;
        this.workshop = workshop;
    }

    public int getBillImportId() {
        return billImportId;
    }

    public void setBillImportId(int billImportId) {
        this.billImportId = billImportId;
    }

    public Workshop getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Workshop workshop) {
        this.workshop = workshop;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
