package com.pantofit.porject1.Controller;

import com.pantofit.porject1.dao.ClientRepository;
import com.pantofit.porject1.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    private ClientRepository clientRepository;
    public ClientController(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }
    @PostMapping("/register")
    public Client Register (@RequestBody String mail,@RequestBody String password){
Client c =new Client(mail,password);
return clientRepository.save(c);
    }
    @PostMapping("/login")
    public Client Login(@RequestBody String mail,@RequestBody String password){
        Client c =clientRepository.findByAddressmailAndPassword(mail, password);
        return c;
    }
}
