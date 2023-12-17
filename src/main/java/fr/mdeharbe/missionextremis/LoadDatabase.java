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
                    new Mission("Si un regard pouvait tuer"),
                    new Mission("Les fous de Gotheim"),
                    new Mission("Coeur de verre"),
                    new Mission("Appât à sorcier"),
                    new Mission("Les coupables"),
                    new Mission("Massacre à Spittlefeld"))
                    .flatMap(repository::save)
                    .subscribe(System.out::println);
        };
    }
}
