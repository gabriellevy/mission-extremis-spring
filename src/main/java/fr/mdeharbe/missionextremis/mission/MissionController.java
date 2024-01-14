package fr.mdeharbe.missionextremis.mission;

import fr.mdeharbe.missionextremis.equipe.Equipe;
import fr.mdeharbe.missionextremis.equipe.EquipeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MissionController {

    private final MissionRepository missionRepo;
    private final EquipeRepository equipeRepo;

    public MissionController(MissionRepository missionRepo, EquipeRepository equipeRepo) {
        this.missionRepo = missionRepo;
        this.equipeRepo = equipeRepo;
    }

    // affichage des missions (+ leur choix ?)
    @GetMapping("/missions")
    public Flux<Mission> listing() {
        return missionRepo.findAll();
    }

    // exécuter une mission avec une équipe particulière ??
    @GetMapping("/mission")
    public Mono<Equipe> listing(@RequestParam(required = true) String idMission,
                                 @RequestParam(required = true) String idEquipe) {
        Mono<Mission> mission = missionRepo.findById(idMission);
        Mono<Equipe> equipe = equipeRepo.findById(idEquipe);
        return mission.flux().then(equipe);
    }
}
