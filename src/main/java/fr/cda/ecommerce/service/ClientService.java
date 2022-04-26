package fr.cda.ecommerce.service;


import fr.cda.ecommerce.model.Client;

import java.util.List;

public interface ClientService {
    public List<Client> getAllClient();
    public Client getClientById(Long clientId);
    public Client save(Client client);
}
