package fr.mdeharbe.missionextremis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class RemplirMissionBdd {

    @Bean({"initMissionBdd"})
    CommandLineRunner init(MissionRepository repository) {
        return args -> {
            Flux.just( // A FAIRE : devrait toujours vérifier que les éléments n'existent pas déjà avant de les recréer (ou tout vider et c'est tout)
                            new Mission("Si un regard pouvait tuer",
                                    new ArrayList<>(Arrays.asList(
                                            new Scene("Bienvenue à bord du trafandir"),
                                            new Scene("Le maître de barge"),
                                            new Scene("La mystique strigany"),
                                            new Scene("Le naufrage")))
                            ),
                            new Mission("Les fous de Gotheim", new ArrayList<>()),
                            new Mission("Coeur de verre", new ArrayList<>()),
                            new Mission("Appât à sorcier", new ArrayList<>()),
                            new Mission("Les coupables", new ArrayList<>()),
                            new Mission("Massacre à Spittlefeld", new ArrayList<>()))
                    .flatMap(repository::save)
                    .subscribe(System.out::println);
        };
    }

}
