
package ua.softserve.hotel.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "ADD_SERVICE_HISTORY")
public class AddServiceHistory implements Serializable{
    @Id
    @Column(name = "ADD_SERVICE_HISTORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "ADD_SERVICE_ID")
    private AddService addService;


    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID")
    private HotelOrder order;


    //���������� ������ ��� ������
    @Column(name="AMOUNT", nullable=false)
    private double amount;

    //���� �� ������� ��� ������� �� ���� ��������
    //���� �������� ��� ������!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //������� �� AddService ������ �.�. ��� ������� ����
    @Column(name = "DATE_PRICE")
    private double datePrice;

    //���� �������� ������
    @Column(name = "OPERATION_DATE")
    @Temporal( value = TemporalType.TIMESTAMP )
    private Date operationDate;

    //������ ������ ��� ���
    @Column(name = "CLIENT_PAID")
    private Boolean ClientPaid;

    //��� ������/��������������� ��� ������
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;


    public HotelOrder getOrder(){
	return order;
    }

    public void setOrder(HotelOrder ho){
	this.order = ho;
    }

    public AddService getAddService() {
        return addService;
    }

    public void setAddService(AddService addService) {
        this.addService = addService;
    }

    public Boolean isClientPaid() {
        return ClientPaid;
    }

    public void setClientPaid(Boolean ClientPaid) {
        this.ClientPaid = ClientPaid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getDatePrice() {
        return datePrice;
    }

    public void setDatePrice(double datePrice) {
        this.datePrice = datePrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOpperationDate() {
        return operationDate;
    }

    public void setOpperationDate(Date opperationDate) {
        this.operationDate = opperationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }






}
