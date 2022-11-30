package HDT.Oneteam.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "sanpham")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MASP")
    private int productId;
    @Column(name = "TENSANPHAM")
    private String productName;
    @Column(name = "DONVITINH")
    private String unit;
    @Column(name = "GIATHANH")
    private double price;
    @Column(name = "SOLUONGTONKHO")
    private int inventory;
    @Column(name = "TRANGTHAI")
    private int status;
    @Column(name = "NGAYNHAP")
    private Timestamp created;
    @Column(name = "NGAYCAPNHAT")
    private Timestamp updated;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<ProductStructure> productStructureList;
    public Product(){}

    public Product(int productId, String productName, String unit, double price, int inventory, int status, Timestamp created, Timestamp updated, List<ProductStructure> productStructureList) {
        this.productId = productId;
        this.productName = productName;
        this.unit = unit;
        this.price = price;
        this.inventory = inventory;
        this.status = status;
        this.created = created;
        this.updated = updated;
        this.productStructureList = productStructureList;
    }

    public Product(int productId, String productName, String unit, double price, int inventory, int status) {
        this.productId = productId;
        this.productName = productName;
        this.unit = unit;
        this.price = price;
        this.inventory = inventory;
        this.status = status;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ProductStructure> getProductStructureList() {
        return productStructureList;
    }

    public void setProductStructureList(List<ProductStructure> productStructureList) {
        this.productStructureList = productStructureList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", inventory=" + inventory +
                ", status=" + status +
                ", created=" + created +
                ", updated=" + updated +
                ", productStructureList=" + productStructureList +
                '}';
    }
}

