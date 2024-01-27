package fr.mdeharbe.missionextremis.equipe.perso;

import fr.mdeharbe.missionextremis.equipe.Equipe;
import fr.mdeharbe.missionextremis.equipe.EquipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class RemplirPersosBdd {
    @Bean({"initPersosBdd"})
    CommandLineRunner init(PersoService persoService) {
        persoService.deleteAllPersos(); // ne semble pas fonctionner...
        return args -> {
            Flux.just(new Perso("Werner Murrmann"),
                      new Perso("L'onête Ottokar Johanson"))
                    .flatMap(persoService::savePerso)
                    .subscribe(System.out::println);
        };
    }
}
