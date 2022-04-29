package fr.cda.ecommerce.service;

import fr.cda.ecommerce.exeption.ResourceNotFoundException;
import fr.cda.ecommerce.model.Client;
import fr.cda.ecommerce.model.Product;
import fr.cda.ecommerce.repository.ClientRepository;
import fr.cda.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("clients")
public class ClientServiceImpl implements ClientService{
    //private final List<Client> allClient = new ArrayList<>();

    @Autowired
    private ClientRepository clientRepository;

    public ClientServiceImpl(){
        super();
    }

    public Optional<Client> findByUsername(String s){
        return clientRepository.findByUsername(s);
    }

    @Override
    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long clientId){
        for (Client client : clientRepository.findAll()){
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
        if(clientRepository.findAll().contains(client)){
            return null;
        }else {
            return clientRepository.save(client);
        }
    }
}
