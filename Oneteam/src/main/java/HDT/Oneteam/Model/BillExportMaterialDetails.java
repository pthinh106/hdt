package HDT.Oneteam.Model;

import javax.persistence.*;

@Entity
@Table(name = "chitietpnnl")
public class BillExportMaterialDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MCTXNL")
    private int billExportDetailsId;
    @ManyToOne
    @JoinColumn(name = "MAPXNL")
    private BillImportMaterial billImportMaterial;
    @ManyToOne
    @JoinColumn(name = "MANL")
    private Material material;
    @Column(name = "SOLUONG")
    private int quantity;
    @Column(name = "DONGIA")
    private double total;

    public BillExportMaterialDetails(){}

    public BillExportMaterialDetails(int billExportDetailsId, BillImportMaterial billImportMaterial, Material material, int quantity, double total) {
        this.billExportDetailsId = billExportDetailsId;
        this.billImportMaterial = billImportMaterial;
        this.material = material;
        this.quantity = quantity;
        this.total = total;
    }

    public int getBillExportDetailsId() {
        return billExportDetailsId;
    }

    public void setBillExportDetailsId(int billExportDetailsId) {
        this.billExportDetailsId = billExportDetailsId;
    }

    public BillImportMaterial getBillImportMaterial() {
        return billImportMaterial;
    }

    public void setBillImportMaterial(BillImportMaterial billImportMaterial) {
        this.billImportMaterial = billImportMaterial;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
