package com.pantofit.porject1.Controller;

import com.pantofit.porject1.dao.AbonnementRepository;
import com.pantofit.porject1.dao.ClientRepository;
import com.pantofit.porject1.dao.SalleRepository;
import com.pantofit.porject1.dao.WorkoutRepository;
import com.pantofit.porject1.entities.Abonnement;
import com.pantofit.porject1.entities.Client;
import com.pantofit.porject1.entities.Salle;
import com.pantofit.porject1.entities.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class WorkoutController {
    @Autowired
    SalleRepository salleRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AbonnementRepository abonnementRepository;
   @Autowired
   WorkoutRepository workoutRepository;
   @PostMapping("/validatesalle")
    public Abonnement validatesalle(@RequestBody Map<String , String> json){
        Salle salle=salleRepository.findByCode(json.get("code"));
        Optional<Client> client=clientRepository.findById(Long.valueOf(json.get("id")));
        Abonnement abonnement= abonnementRepository.findByClientAndCourant(client,true);
        Abonnement c= abonnementRepository.findByClientAndCourant(client,true);

   if(salle!=null &&  abonnement!=null) {

        if (abonnement.getNbrseancerestants() == 1 ) {
            abonnement.setCourant(false);
            abonnement.setNbrseancerestants(abonnement.getNbrseancerestants() - 1);
            abonnementRepository.save(abonnement);
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            workoutRepository.save(new Workout(null, abonnement, salle, date));

        } else if(abonnement.getNbrseancerestants()>1) {
            abonnement.setNbrseancerestants(abonnement.getNbrseancerestants() - 1);
            abonnementRepository.save(abonnement);
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            workoutRepository.save(new Workout(null, abonnement, salle, date));

        }
       return abonnement;
    }
       // abonnementRepository.
        return  new Abonnement();
    }
}
