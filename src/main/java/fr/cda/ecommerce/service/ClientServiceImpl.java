package fr.cda.ecommerce.service;

import fr.cda.ecommerce.exeption.ResourceNotFoundException;
import fr.cda.ecommerce.model.Client;
import fr.cda.ecommerce.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ClientServiceImpl implements ClientService{
    private final List<Client> allClient = new ArrayList<>();

    public ClientServiceImpl(){
        super();
    }

    @Override
    public List<Client> getAllClient(){
        return allClient;
    }

    @Override
    public Client getClientById(Long clientId){
        for (Client client : allClient){
            if(client.getId().equals(clientId)){
                return client;
            }else{
                throw new ResourceNotFoundException("pas de correspondance avec cet ID");
            }
        }
        return null;
    }

    @Override
    public Client save(Client client){
        if(allClient.contains(client)){
            return null;
        }else {
            this.allClient.add(client);
            return client;
        }
    }
}
