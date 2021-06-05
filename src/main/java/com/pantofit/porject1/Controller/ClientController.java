package com.pantofit.porject1.Controller;

import com.pantofit.porject1.dao.AbonnementRepository;
import com.pantofit.porject1.dao.ClientRepository;
import com.pantofit.porject1.entities.Abonnement;
import com.pantofit.porject1.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class ClientController {
    private ClientRepository clientRepository;
    private AbonnementRepository abonnementRepository;
    public ClientController(ClientRepository clientRepository,AbonnementRepository abonnementRepository){
        this.clientRepository=clientRepository;
        this.abonnementRepository=abonnementRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Client Register (@RequestBody Map<String , String> json){
        if (clientRepository.findByAddressmail(json.get("mail"))==null) {
            Client c = new Client(json.get("mail"), json.get("password"));
            clientRepository.save(c);
            return c;
        }
        return new Client();
    }
    @PostMapping("/login")
    public Client Login(@RequestBody Map<String , String> json){
        Client c =clientRepository.findByAddressmailAndPassword(json.get("mail"),json.get("password"));
        return c;
    }
    @PostMapping("/abonnementclient")
    public Abonnement GetAbonnement(@RequestBody Map<String , String> json){
        Optional<Client> client=clientRepository.findById(Long.valueOf(json.get("id")));
        Abonnement abonnement =abonnementRepository.findByClientAndCourant(client,true);
        //Abonnement c =abon.findByAddressmailAndPassword(json.get("mail"),json.get("password"));
       //return c;
        return abonnement;
    }

}
