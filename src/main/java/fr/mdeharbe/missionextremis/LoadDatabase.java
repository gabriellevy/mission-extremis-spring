package fr.mdeharbe.missionextremis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner init(MissionRepository repository) {
        return args -> {
            Flux.just(
                    new Mission("Allez le premier"),
                    new Mission("et puis un autre"),
                    new Mission("mais c'est tout"))
                    .flatMap(repository::save)
                    .subscribe(System.out::println);
        };
    }
}
