package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model")
    private String name;

    @Column(name = "series")
    private String series;

    @OneToOne(mappedBy = "car")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;



    public Car(String name, String series) {
        this.name = name;
        this.series = series;
    }

    public Car() {
    }

    public User getUser() {
        return user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }
}
