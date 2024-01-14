package fr.mdeharbe.missionextremis.equipe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class RemplirEquipeBdd {
    @Bean({"initEquipeBdd"})
    CommandLineRunner init(EquipeRepository repository) {
        return args -> {
            Flux.just( // A FAIRE : devrait toujours vérifier que les éléments n'existent pas déjà avant de les recréer (ou tout vider et c'est tout)
                            new Equipe("Équipe 1",
                                    new ArrayList<>(Arrays.asList(
                                            new Perso("Werner Murrmann"),
                                            new Perso("L'onête Ottokar Johanson")))
                            ))
                    .flatMap(repository::save)
                    .subscribe(System.out::println);
        };
    }
}
