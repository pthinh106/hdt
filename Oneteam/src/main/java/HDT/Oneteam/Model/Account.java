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

    public Account(){}

    public Account(int accountId, String userName, String passWord, Role role) {
        this.accountId = accountId;
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
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
}
