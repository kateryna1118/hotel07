package ua.softserve.hotel.domain;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "ROOM")
public class Room implements Serializable {

    @Id
    @Column(name = "ROOM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column( name = "NUMBER")
    //nullable = false,
    private int number;

    @ManyToOne
    @JoinColumn(name = "NAME")
    private RoomType roomType;

    //�����, � ������� ��� ��������
    //��� ���-�� ������ ������������ � ����������� �������� �� Order
    //� � ������ �������
    @Column(nullable = false, name = "ROOM_STATE")
    private String roomState;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRoomState() {
        return roomState;
    }

    public void setRoomState(String roomState) {
        this.roomState = roomState;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }


}
