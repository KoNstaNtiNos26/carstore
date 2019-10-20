package model;


import javax.persistence.*;

@Entity
@Table(name = "carstore")
public class EntityCar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "producer", nullable = true)
    private String producer;

    @Column(name = "carmod", nullable = true)
    private String carmod;

    @Column(name = "bodywork", nullable = true)
    private String bodywork;

    @Column(name = "yearproduce", nullable = true)
    private String yearproduce;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getCarmod() {
        return carmod;
    }

    public void setCarmod(String carmod) {
        this.carmod = carmod;
    }

    public String getBodywork() {
        return bodywork;
    }

    public void setBodywork(String bodywork) {
        this.bodywork = bodywork;
    }

    public String getYearproduce() {
        return yearproduce;
    }

    public void setYearproduce(String yearproduce) {
        this.yearproduce = yearproduce;
    }
}
