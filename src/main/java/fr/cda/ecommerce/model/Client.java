package fr.cda.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "client")
public class Client implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable(
            name = "table_client_role",
            joinColumns = @JoinColumn(name = "fk_client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "fk_role_id", referencedColumnName = "id")
    )
    private List<Role> role;

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
    public void setPassword(String newPass){
        this.password = newPass;
    }

    public List<Role> getRole(){
        return role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }



}

