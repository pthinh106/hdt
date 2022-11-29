package HDT.Oneteam.Model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "hopdong")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAHD")
    private int contractId;
    @ManyToOne
    @JoinColumn(name = "MANV")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "MAKH")
    private Customer customer;
    @Column(name = "NGAYKI")
    private Timestamp created;
    @Column(name = "NGAYBANGIAO")
    private Date updated;
    @Column(name = "NOIGIAO")
    private String deliveryPlace;
    @Column(name = "DIEUKHOAN")
    private String provision;
    @ManyToOne
    @JoinColumn(name = "MAPTTT")
    private Payment payment;
    @Column(name = "TRIGIAHD")
    private double total;
    @Column(name = "TRANGTHAI")
    private int status;
    @Column(name = "THANHLI")
    private int liquidationStatus;
    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    private List<ContractDetails> contractDetailsList;
    public Contract(){}

    public Contract(int contractId, Employee employee, Customer customer, Timestamp created, Date updated, String deliveryPlace, String provision, Payment payment, double total, int status, int liquidationStatus, List<ContractDetails> contractDetailsList) {
        this.contractId = contractId;
        this.employee = employee;
        this.customer = customer;
        this.created = created;
        this.updated = updated;
        this.deliveryPlace = deliveryPlace;
        this.provision = provision;
        this.payment = payment;
        this.total = total;
        this.status = status;
        this.liquidationStatus = liquidationStatus;
        this.contractDetailsList = contractDetailsList;
    }

    public Contract(int contractId, Employee employee, Customer customer, String deliveryPlace, String provision, Payment payment, double total, int status, int liquidationStatus) {
        this.contractId = contractId;
        this.employee = employee;
        this.customer = customer;
        this.deliveryPlace = deliveryPlace;
        this.provision = provision;
        this.payment = payment;
        this.total = total;
        this.status =status;
        this.liquidationStatus = liquidationStatus;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

    public String getProvision() {
        return provision;
    }

    public void setProvision(String provision) {
        this.provision = provision;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
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

    public int getLiquidationStatus() {
        return liquidationStatus;
    }

    public void setLiquidationStatus(int liquidationStatus) {
        this.liquidationStatus = liquidationStatus;
    }

    public List<ContractDetails> getContractDetailsList() {
        return contractDetailsList;
    }

    public void setContractDetailsList(List<ContractDetails> contractDetailsList) {
        this.contractDetailsList = contractDetailsList;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", employee=" + employee +
                ", customer=" + customer +
                ", created=" + created +
                ", updated=" + updated +
                ", deliveryPlace='" + deliveryPlace + '\'' +
                ", provision='" + provision + '\'' +
                ", payment=" + payment +
                ", total=" + total +
                ", status=" + status +
                ", liquidationStatus=" + liquidationStatus +
                '}';
    }
}
