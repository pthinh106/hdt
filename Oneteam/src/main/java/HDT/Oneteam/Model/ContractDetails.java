package HDT.Oneteam.Model;

import javax.persistence.*;

@Entity
@Table(name = "chitiethd")
public class ContractDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MACTHD")
    private int contractDetailsIdl;
    @ManyToOne
    @JoinColumn(name = "MAHD")
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "MASP")
    private Product product;
    @Column(name = "SOLUONG")
    private int quantity;
    @Column(name = "DONGIA")
    private double total;

    public ContractDetails(){}

    public ContractDetails(int contractDetailsIdl, Contract contract, Product product, int quantity, double total) {
        this.contractDetailsIdl = contractDetailsIdl;
        this.contract = contract;
        this.product = product;
        this.quantity = quantity;
        this.total = total;
    }

    public int getContractDetailsIdl() {
        return contractDetailsIdl;
    }

    public void setContractDetailsIdl(int contractDetailsIdl) {
        this.contractDetailsIdl = contractDetailsIdl;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
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
