package fr.mdeharbe.missionextremis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class EvtController {

    private final EvtRepository repository;

    public EvtController(EvtRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/evts")
    public Flux<Mission> listing() {
        return repository.findAll();
    }
}
