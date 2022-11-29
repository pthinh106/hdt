package HDT.Oneteam.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "phieunhapnl")
public class BillImportMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAPNNL")
    private int billImportId;
    @ManyToOne
    @JoinColumn(name = "MAHD")
    private Contract contract;
    @Column(name = "NGAYNHAP")
    private Timestamp created;
    @Column(name = "VAT")
    private double vat;
    @Column(name = "TRIGIA")
    private double total;
    @Column(name = "TRANGTHAI")
    private int status;
    public BillImportMaterial(){}

    public BillImportMaterial(Contract contract, double vat, double total,int status) {
        this.contract = contract;
        this.vat = vat;
        this.total = total;
        this.status = status;
    }

    public int getBillImportId() {
        return billImportId;
    }

    public void setBillImportId(int billImportId) {
        this.billImportId = billImportId;
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

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
