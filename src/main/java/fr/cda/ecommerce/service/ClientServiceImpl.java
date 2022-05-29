package fr.cda.ecommerce.service;

import fr.cda.ecommerce.dto.ClientDTO;
import fr.cda.ecommerce.exeption.ResourceNotFoundException;
import fr.cda.ecommerce.model.Client;
import fr.cda.ecommerce.model.Role;
import fr.cda.ecommerce.repository.ClientRepository;
import fr.cda.ecommerce.security.MyClientPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service("clients")
public class ClientServiceImpl implements ClientService, UserDetailsService {
    //private final List<Client> allClient = new ArrayList<>();

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<Client> optionalClient = clientRepository.findByUsername(username);
        if (!optionalClient.isPresent()){
            throw new UsernameNotFoundException(username + "inexistant en base");
        }
        return new MyClientPrincipal(optionalClient.get());
    }

    @Override
    public void newClientRegister(ClientDTO clientDto){
        if(validFormPassword(clientDto.getPassword())){
            clientDto.setPassword(passwordEncoder.encode(clientDto.getPassword()));
            Client currentClient = clientDto.dtoToClient();
            List<Role> roles = new ArrayList<Role>();
            roles.add(new Role(1l, "ROLE_CLIENT"));
            currentClient.setRole(roles);

            if(comparatePassword(clientDto.getPassword(), clientDto.getConfirmPassword())){
                clientRepository.save(currentClient);
                System.out.println("nouveau client créé");
            }else{
                System.out.println("password not valid ou not confirmed");
            }
        }else{
            System.out.println("password format not valid");
        }

    }

    @Override
    public boolean comparatePassword(String pass1, String pass2){
        return pass1.equals(pass2);
    }

    @Override
    public boolean validFormPassword(String pass) {
        boolean status = false;
        System.out.println("pass = "+pass);
        String[] listSpeCaract = {"*", "-", "_", "(", ")", "&", "!", "+", ".", "/", ",", ";", ":", "'", "<", ">", "@", "°", "%", "€", "£"};
        List<String> list = Arrays.asList(listSpeCaract);

        if (Character.isUpperCase(pass.charAt(0))) {
            status = true;
            System.out.println("pas de maj sur le 1er char");
        }
        if (pass.length() < 6) {
            status = false;
            System.out.println("pass inf a 6 char");
        }
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i))) {
                status = true;
                System.out.println("password pas de digit");
            }
        }
        for (int j = 0; j < pass.length(); j++) {
            if(list.contains(pass.charAt(j))) {
                status = true;
                System.out.println("password pas de char spe");
            }
        }
        return status;
    }
}
