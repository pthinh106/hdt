package HDT.Oneteam.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "phieuxuatsp")
public class BillExportProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAPXSP")
    private int billExportId;
    @ManyToOne
    @JoinColumn(name = "MAHD")
    private Contract contract;
    @Column(name = "NGAYXUAT")
    private Timestamp created;
    @Column(name = "TRANGTHAI")
    private int status;
    public BillExportProduct(){}

    public BillExportProduct(int billExportId, Contract contract,int status) {
        this.billExportId = billExportId;
        this.contract = contract;
        this.status = status;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public int getBillExportId() {
        return billExportId;
    }

    public void setBillExportId(int billExportId) {
        this.billExportId = billExportId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }
}
