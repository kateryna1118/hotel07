
package ua.softserve.hotel.domain;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "ADD_SERVICE")
public class AddService implements Serializable {
 @Id
    @Column(name = "ADD_SERVICE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  @Column(name = "NAME")
    private String name;

  //���� �� �������
    @Column(name = "PRICE")
    private double price;

 @Column(name = "DESCRIPTION")
    private String description;

    public String getDiscription() {
        return description;
    }

    public void setDiscription(String discription) {
        this.description = discription;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
