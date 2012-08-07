package ua.softserve.hotel.domain;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "ROOM_TYPE")
public class RoomType  {

    @Id
    @Column(name = "ROOM_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ROOMS_VIEW")
    private String RoomsView;

    @Column(name = "NUMBER_OF_PLACES")
    private int numberOfPlaces;

//?????????? ??????
    @Column(name = "NUMBER_OF_ROOMS")
    private int numberOfRooms;
//???? ? ?????
    @Column(name = "PRICE")
    private double price;

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

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRoomsView() {
        return RoomsView;
    }

    public void setRoomsView(String RoomsView) {
        this.RoomsView = RoomsView;
    }


}
