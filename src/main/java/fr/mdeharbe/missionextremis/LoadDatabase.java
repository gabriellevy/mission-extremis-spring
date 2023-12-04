package fr.mdeharbe.missionextremis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner init(ChapterRepository repository) {
        return args -> {
            Flux.just(
                    new Chapter("Allez le premier"),
                    new Chapter("et puis un autre"),
                    new Chapter("mais c'est tout"))
                    .flatMap(repository::save)
                    .subscribe(System.out::println);
        };
    }
}
