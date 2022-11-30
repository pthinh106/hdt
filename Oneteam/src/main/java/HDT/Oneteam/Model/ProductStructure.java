package HDT.Oneteam.Model;

import javax.persistence.*;

@Entity
@Table(name = "cocausp")
public class ProductStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MACCSP")
    private int productStructureId;
    @ManyToOne
    @JoinColumn(name = "MASP")
    private Product product;
    @ManyToOne
    @JoinColumn(name = "MANL")
    private Material material;
    @Column(name = "SOLUONG")
    private double quantity;

    public ProductStructure(){}

    public ProductStructure(int productStructureId, Product product, Material material, double quantity) {
        this.productStructureId = productStructureId;
        this.product = product;
        this.material = material;
        this.quantity = quantity;
    }

    public int getProductStructureId() {
        return productStructureId;
    }

    public void setProductStructureId(int productStructureId) {
        this.productStructureId = productStructureId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ProductStructure{" +
                "productStructureId=" + productStructureId +
                ", material=" + material +
                ", quantity=" + quantity +
                '}';
    }
}
