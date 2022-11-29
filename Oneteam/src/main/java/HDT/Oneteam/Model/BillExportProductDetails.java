package HDT.Oneteam.Model;

import javax.persistence.*;

@Entity
@Table(name = "chitietpxsp")
public class BillExportProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MCTXSP")
    private int billExportDetailsId;
    @ManyToOne
    @JoinColumn(name = "MAPXSP")
    private BillExportProduct billExportProduct;
    @ManyToOne
    @JoinColumn(name = "MASP")
    private Product product;
    @Column(name = "SOLUONG")
    private int quantity;
    @Column(name = "DONGIA")
    private double total;

    public BillExportProductDetails(){}

    public BillExportProductDetails(int billExportDetailsId, BillExportProduct billExportProduct, Product product, int quantity, double total) {
        this.billExportDetailsId = billExportDetailsId;
        this.billExportProduct = billExportProduct;
        this.product = product;
        this.quantity = quantity;
        this.total = total;
    }

    public int getBillExportDetailsId() {
        return billExportDetailsId;
    }

    public void setBillExportDetailsId(int billExportDetailsId) {
        this.billExportDetailsId = billExportDetailsId;
    }

    public BillExportProduct getBillExportProduct() {
        return billExportProduct;
    }

    public void setBillExportProduct(BillExportProduct billExportProduct) {
        this.billExportProduct = billExportProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
