package fr.cda.ecommerce.repository;

import fr.cda.ecommerce.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    public abstract Optional<Client>findByUsername(String username);
}
