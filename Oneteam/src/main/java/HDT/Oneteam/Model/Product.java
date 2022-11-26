package HDT.Oneteam.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sanpham")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MASP")
    private int productId;
    @Column(name = "TENSANPHAM")
    private String productName;
    @Column(name = "GIATHANH")
    private double price;
    @Column(name = "SOLUONGTONKHO")
    private int inventory;
    @Column(name = "NGAYNHAP")
    private Timestamp created;
    @Column(name = "NGAYCAPNHAT")
    private Timestamp updated;
    public Product(){}

    public Product(int productId, String productName, double price, int inventory) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.inventory = inventory;
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
}
