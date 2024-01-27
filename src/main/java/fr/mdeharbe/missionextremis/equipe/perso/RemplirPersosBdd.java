package fr.mdeharbe.missionextremis.equipe.perso;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

@Configuration
public class RemplirPersosBdd {
    @Bean({"initPersosBdd"})
    CommandLineRunner init(PersoService persoService) {
        persoService.deleteAllPersos(); // ne semble pas fonctionner...
        return args -> {
            Flux.just(new Perso("Werner Murrmann", false),
                      new Perso("L'onête Ottokar Johanson", false))
                    .flatMap(persoService::savePerso)
                    .subscribe(System.out::println);
        };
    }
}
