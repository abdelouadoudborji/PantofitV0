package com.pantofit.porject1.Controller;

import com.pantofit.porject1.dao.SalleRepository;
import com.pantofit.porject1.entities.Client;
import com.pantofit.porject1.entities.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@CrossOrigin(origins = "*")
@RestController
public class SalleController {
    @Autowired
    SalleRepository salleRepository;
    @PostMapping("/loginsalle")
    public Salle Login(@RequestBody Map<String , String> json){
       Salle s =salleRepository.findByAddressmailAndPassword(json.get("mail"),json.get("password"));
       if (s!=null) {
           return s;
       }
       return new Salle();
    }
   /* @RequestMapping(value = "/salles", method = RequestMethod.POST)
    @ResponseBody
    public Salle Register (@RequestBody  Salle salle){
        if (salleRepository.findByAddressmail(salle.getAddressmail())==null) {
System.out.println(salle.getVille());
        salleRepository.save(salle);
            return salle;
        }
        return new Salle();
    }
  /*  @PostMapping("/login")
    public Client Login(@RequestBody Map<String , String> json){
        Client c =clientRepository.findByAddressmailAndPassword(json.get("mail"),json.get("password"));
        return c;
    }c*/
   /*@RequestMapping(value = "/ClientWorkout", method = RequestMethod.POST)
   @ResponseBody
   public List<Client> ClientWorkout (@RequestBody  Long id){
       if (salleRepository.getOne(id)!=null) {
           System.out.println(salle.getVille());
           salleRepository.save(salle);
           return salle;
       }
       return new Salle();
   }*/
}
