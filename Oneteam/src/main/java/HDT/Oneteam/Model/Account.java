package HDT.Oneteam.Model;

import javax.persistence.*;

@Entity
@Table(name = "taikhoan")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MATK")
    private int accountId;
    @Column(name = "TENDANGNHAP")
    private String userName;
    @Column(name = "MATKHAU")
    private String passWord;
    @ManyToOne
    @JoinColumn(name = "MAQ")
    private Role role;
    @Column(name = "TRANGTHAI")
    private int status;
    public Account(){}

    public Account(int accountId, String userName, String passWord, Role role, int status) {
        this.accountId = accountId;
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
        this.status = status;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", role=" + role +
                ", status=" + status +
                '}';
    }
}
