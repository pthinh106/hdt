package HDT.Oneteam.Model;

import javax.persistence.*;

@Entity
@Table(name = "khachhang")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAKH")
    private int customerId;
    @Column(name = "TENKHACHHANG")
    private String customerName;
    @Column(name = "DIACHI")
    private String address;
    @Column(name = "MASOTHUE")
    private String tax;
    @Column(name = "SDT")
    private String phoneNumber;
    public Customer(){}

    public Customer(int customerId, String customerName, String address, String tax, String phoneNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.address = address;
        this.tax = tax;
        this.phoneNumber = phoneNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", tax='" + tax + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
