package ua.softserve.hotel.domain;

import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author Kateryna
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "LOGIN")
    private String login;

//    @Column
    @ManyToOne
    @JoinColumn(name = "NAME")
    private Role role;

  @Column(nullable = false, name="PASSWORD")
    private String password;

  @Column(name="POST")
  private String post;

  @OneToOne(optional=false, cascade=CascadeType.ALL)
  @JoinColumn(name="PERSON_ID")
  private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }


}
