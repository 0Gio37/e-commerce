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
        clientDto.setPassword(passwordEncoder.encode(clientDto.getPassword()));
        Client currentClient = clientDto.dtoToClient();
        List<Role> roles = new ArrayList<Role>();
        roles.add(new Role(1l, "ROLE_CLIENT"));
        currentClient.setRole(roles);

        if(comparatePassword(clientDto.getPassword(), clientDto.getConfirmPassword())){
            clientRepository.save(currentClient);
        }
    }

    @Override
    public boolean comparatePassword(String pass1, String pass2){
        return pass1.equals(pass2);
    }

    @Override
    public boolean validFormPassword(String pass) {
        boolean status = true;
        String[] listSpeCaract = {"*", "-", "_", "(", ")", "&", "!", "+", ".", "/", ",", ";", ":", "'", "<", ">", "@", "°", "%", "€", "£"};
        List<String> list = Arrays.asList(listSpeCaract);

        if (!Character.isUpperCase(pass.charAt(0))) {
            status = false;
        }
        if (pass.length() < 6) {
            status = false;
        }
        for (int i = 0; i < pass.length(); i++) {
            if (Character.isDigit(pass.charAt(i))) {
                status = false;
            }
            for (int j = 0; j < pass.length(); j++) {
                if (list.contains(pass.charAt(j))) {
                    status = false;
                }


            }


            return status;
        }
    }


}
