package fr.cda.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

    public Client() {
        super();
    }


    public Client(Long id, String username, String password) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
@JsonIgnore
@JsonProperty(value = "password")
    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", username=" + username + ", password=" + password + "]";
    }

}

