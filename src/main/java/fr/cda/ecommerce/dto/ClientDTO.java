package fr.cda.ecommerce.dto;

import fr.cda.ecommerce.model.Client;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;


public class ClientDTO{
    @NonNull
    @NotEmpty
    private String username;
    @NonNull
    @NotEmpty
    private String password;
    @NonNull
    @NotEmpty
    private String confirmPassword;


    public ClientDTO(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String password) {
        this.confirmPassword = password;
    }

    public Client dtoToClient(){
        return new Client(null, this.username, this.password);
    }
    
}

