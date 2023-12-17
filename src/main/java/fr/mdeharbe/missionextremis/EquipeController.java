package fr.mdeharbe.missionextremis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
@RestController
public class EquipeController {

    private final EquipeRepository repository;

    public EquipeController(EquipeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/equipes")
    public Flux<Equipe> listing() {
        return repository.findAll();
    }
}
