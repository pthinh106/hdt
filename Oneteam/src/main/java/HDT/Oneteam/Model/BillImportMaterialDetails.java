package HDT.Oneteam.Model;

import javax.persistence.*;

@Entity
@Table(name = "chitietpnnl")
public class BillImportMaterialDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MCTNNL")
    private int billImportDetailsId;
    @ManyToOne
    @JoinColumn(name = "MAPNNL")
    private BillImportMaterial billImportMaterial;
    @ManyToOne
    @JoinColumn(name = "MANL")
    private Material material;
    @Column(name = "SOLUONG")
    private int quantity;
    @Column(name = "DONGIA")
    private double total;

    public BillImportMaterialDetails(){}

    public BillImportMaterialDetails(int billImportDetailsId, BillImportMaterial billImportMaterial, Material material, int quantity, double total) {
        this.billImportDetailsId = billImportDetailsId;
        this.billImportMaterial = billImportMaterial;
        this.material = material;
        this.quantity = quantity;
        this.total = total;
    }

    public int getBillImportDetailsId() {
        return billImportDetailsId;
    }

    public void setBillImportDetailsId(int billImportDetailsId) {
        this.billImportDetailsId = billImportDetailsId;
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
