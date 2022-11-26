package HDT.Oneteam.Model;

import javax.persistence.*;

@Entity
@Table(name = "phuongthucthanhtoan")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAPTTT")
    private int paymentId;
    @Column(name = "LOAIPTTT")
    private String paymentName;
    public Payment(){}

    public Payment(int paymentId, String paymentName) {
        this.paymentId = paymentId;
        this.paymentName = paymentName;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
}
