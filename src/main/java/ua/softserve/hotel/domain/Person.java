package ua.softserve.hotel.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PERSON")
public class Person implements Serializable {

    @Id
    @Column(name = "PERSON_ID")
    @GeneratedValue
    private Integer id;

    @Column( name = "F_NAME")
    //nullable = false,
    private String fName;

    @Column(name = "L_NAME")
    private String lName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

//	@OneToOne(optional=false, cascade=CascadeType.ALL)
//    @JoinColumn(name="USER_ID")
//    private User user;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

}
