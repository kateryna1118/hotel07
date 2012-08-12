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

    @ManyToOne
    @JoinColumn(name = "ADD_SERVICE_ID")
    private AddService addService;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private HotelOrder order;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "OPERATION_DATE")
    @Temporal( value = TemporalType.TIMESTAMP )

    private Date operationDate;
    @Column(name = "CLIENT_PAID")

    private Boolean clientPaid;

    @Column(name = "AMOUNT")
    //, nullable=false
    private int amount;

//    @Column(name = "DATE_PRICE")
//    private double datePrice;


    //getters &setters=========================================================
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

    public Boolean getClientPaid() {
        return clientPaid;
    }

    public void setClientPaid(Boolean clientPaid) {
        this.clientPaid = clientPaid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public double getDatePrice() {
//        return datePrice;
//    }
//
//    public void setDatePrice(double datePrice) {
//        this.datePrice = datePrice;
//    }

}
