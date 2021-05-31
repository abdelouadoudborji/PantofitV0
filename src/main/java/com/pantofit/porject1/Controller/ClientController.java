package com.pantofit.porject1.Controller;

import com.pantofit.porject1.dao.ClientRepository;
import com.pantofit.porject1.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ClientController {
    private ClientRepository clientRepository;
    public ClientController(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }
    @AllArgsConstructor @Data
    class User{
        private String mail;
        private String password;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Client Register (@RequestBody Map<String , String> json){
Client c =new Client(json.get("mail"),json.get("password"));
 clientRepository.save(c);
        return c;
    }
    @PostMapping("/login")
    public Client Login(@RequestBody Map<String , String> json){
        Client c =clientRepository.findByAddressmailAndPassword(json.get("mail"),json.get("password"));
        return c;
    }
}
