package HDT.Oneteam.Model;

import javax.persistence.*;

@Entity
@Table(name = "phanxuong")
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAPX")
    private int workshopId;
    @Column(name = "TENPHANXUONG")
    private String workshopName;
    @Column(name = "DIACHI")
    private String address;
    @Column(name = "SDT")
    private String phoneNumber;

    public Workshop(){}

    public Workshop(int workshopId, String workshopName, String address, String phoneNumber) {
        this.workshopId = workshopId;
        this.workshopName = workshopName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getWorkshopId() {
        return workshopId;
    }

    public void setWorkshopId(int workshopId) {
        this.workshopId = workshopId;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
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
