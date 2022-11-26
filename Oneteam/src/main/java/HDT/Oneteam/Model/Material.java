package HDT.Oneteam.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "nguyenlieu")
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANL")
    private int materialId;
    @Column(name = "TENNGUYENLIEU")
    private String materialName;
    @Column(name = "GIATHANH")
    private double price;
    @Column(name = "SOLUONGTONKHO")
    private int inventory;
    @Column(name = "NGAYNHAP")
    private Timestamp create;
    @Column(name = "NGAYCAPNHAT")
    private Timestamp updated;

    public Material(){}

    public Material(int materialId, String materialName, double price, int inventory) {
        this.materialId = materialId;
        this.materialName = materialName;
        this.price = price;
        this.inventory = inventory;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
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

    public Timestamp getCreate() {
        return create;
    }

    public void setCreate(Timestamp create) {
        this.create = create;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }
}
