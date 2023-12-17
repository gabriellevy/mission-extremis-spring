package fr.mdeharbe.missionextremis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class MissionController {

    private final MissionRepository repository;

    public MissionController(MissionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/missions")
    public Flux<Mission> listing() {
        return repository.findAll();
    }
}
