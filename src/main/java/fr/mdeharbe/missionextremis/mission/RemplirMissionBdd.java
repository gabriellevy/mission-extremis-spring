package fr.mdeharbe.missionextremis.mission;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class RemplirMissionBdd {

    /**
     * revide et recrée la bdd à chaque lancement
     * (un peu bourrin mais pratique pour les tests, on va laisser comme ça pour l'instant)
     */
    @Bean({"initMissionBdd"})
    CommandLineRunner init(MongoOperations mongoOperations) {
        return args -> {
            mongoOperations.dropCollection(Mission.class);

            mongoOperations.insert(new Mission("Si un regard pouvait tuer",
                    new ArrayList<>(Arrays.asList(
                            new Scene("Bienvenue à bord du trafandir"),
                            new Scene("Le maître de barge"),
                            new Scene("La mystique strigany"),
                            new Scene("Le naufrage")))
            ));
            mongoOperations.insert(new Mission("Les fous de Gotheim", new ArrayList<>()));
            mongoOperations.insert(new Mission("Coeur de verre", new ArrayList<>()));
            mongoOperations.insert(new Mission("Appât à sorcier", new ArrayList<>()));
            mongoOperations.insert(new Mission("Les coupables", new ArrayList<>()));
            mongoOperations.insert(new Mission("Massacre à Spittlefeld", new ArrayList<>()));

            mongoOperations.findAll(Mission.class).forEach(mission -> {
                System.out.println(mission.toString());
            });
        };
    }
}
