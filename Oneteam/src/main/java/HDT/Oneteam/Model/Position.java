package HDT.Oneteam.Model;

import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table(name = "chucvu")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MACV")
    private int positionId;
    @Column(name = "TENCHUCVU")
    private String positionName;
    public Position(){}

    public Position(int positionId, String positionName) {
        this.positionId = positionId;
        this.positionName = positionName;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
}
