package HDT.Oneteam.Model;

import javax.persistence.*;

@Entity
@Table(name = "chitietpnsp")
public class BillImportProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MCTNSP")
    private int billImportDetailsId;
    @ManyToOne
    @JoinColumn(name = "MAPNSP")
    private BillImportProduct billImportProduct;
    @ManyToOne
    @JoinColumn(name = "MASP")
    private Product product;
    @Column(name = "SOLUONG")
    private int quantity;
    @Column(name = "DONGIA")
    private double total;

    public BillImportProductDetails(){}

    public BillImportProductDetails(int billImportDetailsId, BillImportProduct billImportProduct, Product product, int quantity, double total) {
        this.billImportDetailsId = billImportDetailsId;
        this.billImportProduct = billImportProduct;
        this.product = product;
        this.quantity = quantity;
        this.total = total;
    }

    public int getBillImportDetailsId() {
        return billImportDetailsId;
    }

    public void setBillImportDetailsId(int billImportDetailsId) {
        this.billImportDetailsId = billImportDetailsId;
    }

    public BillImportProduct getBillImportProduct() {
        return billImportProduct;
    }

    public void setBillImportProduct(BillImportProduct billImportProduct) {
        this.billImportProduct = billImportProduct;
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
