package fr.cda.ecommerce.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;

    public Role() {
        super();
    }

    public Role(Long id, String nom) {
        super();
        this.id = id;
        this.nom = nom;
    }


    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }
}
