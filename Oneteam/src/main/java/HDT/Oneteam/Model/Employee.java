package HDT.Oneteam.Model;

import javax.persistence.*;

@Entity
@Table(name = "nhanvien")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANV")
    private int employeeId;
    @OneToOne
    @JoinColumn(name = "MATK")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "MACV")
    private Position position;
    @Column(name = "TENNHANVIEN")
    private String employeeName;
    @Column(name = "DIACHI")
    private String address;
    @Column(name = "SDT")
    private String phoneNumber;
    public Employee(){}

    public Employee(int employeeId, Account account, Position position, String employeeName, String address, String phoneNumber) {
        this.employeeId = employeeId;
        this.account = account;
        this.position = position;
        this.employeeName = employeeName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
