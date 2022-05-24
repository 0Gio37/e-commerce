package fr.cda.ecommerce.service;


import fr.cda.ecommerce.model.Client;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    public List<Client> getAllClient();
    public Client getClientById(Long clientId);
    public Client save(Client client);
    public Optional<Client> findByUsername(String username);
}
