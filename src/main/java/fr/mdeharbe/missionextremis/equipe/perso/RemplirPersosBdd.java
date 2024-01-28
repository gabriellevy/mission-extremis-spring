package fr.mdeharbe.missionextremis.equipe.perso;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class RemplirPersosBdd {

    /**
     * revide et recrée la bdd à chaque lancement
     * (un peu bourrin mais pratique pour les tests, on va laisser comme ça pour l'instant)
     */
    @Bean({"initPersosBdd"})
    CommandLineRunner init(MongoOperations mongoOperations) {
        return args -> {
            mongoOperations.dropCollection(Perso.class);

            mongoOperations.insert(new Perso("Werner Murrmann", false));
            mongoOperations.insert(new Perso("L'onête Ottokar Johanson", false));

            mongoOperations.findAll(Perso.class).forEach(perso -> {
                System.out.println(perso.toString());
            });
        };
    }
}
