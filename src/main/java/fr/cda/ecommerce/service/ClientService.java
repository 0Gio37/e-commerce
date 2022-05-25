package fr.cda.ecommerce.service;


import fr.cda.ecommerce.dto.ClientDTO;
import fr.cda.ecommerce.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    public List<Client> getAllClient();
    public Client getClientById(Long clientId);
    public Client save(Client client);
    public Optional<Client> findByUsername(String username);
    public void newClientRegister(ClientDTO clientDto);
    public boolean comparatePassword(String pass1, String pass2);
    public boolean validFormPassword(String pass);
}
