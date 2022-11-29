package HDT.Oneteam.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "phieuxuatnl")
public class BillExportMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAPXNL")
    private int billExportId;
    @ManyToOne
    @JoinColumn(name = "MAPX")
    private Workshop workshop;
    @Column(name = "NGAYXUAT")
    private Timestamp created;
    @Column(name = "TRANGTHAI")
    private int status;

    public BillExportMaterial(){}

    public BillExportMaterial(int billExportId, Workshop workshop,int status) {
        this.billExportId = billExportId;
        this.workshop = workshop;
        this.created = created;
    }

    public int getBillExportId() {
        return billExportId;
    }

    public void setBillExportId(int billExportId) {
        this.billExportId = billExportId;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
