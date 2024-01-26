package fr.mdeharbe.missionextremis.mission;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class RemplirMissionBdd {

    @Bean({"initMissionBdd"})
    CommandLineRunner init(MissionService missionService) {
        return args -> {
            missionService.deleteAllMissions(); // ne semble pas fonctionner...
            Flux.just(
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
                    .flatMap(missionService::saveMission)
                    .subscribe(System.out::println);
        };
    }
}
