package fr.mdeharbe.missionextremis.mission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * controller pour l'affichage des données brutes
 */
@RestController
public class MissionController {
    private MissionService missionService;

    @Autowired
    public MissionController(MissionService reservationService) {
        this.missionService = reservationService;
    }

    @GetMapping("/missions")
    public Flux<Mission> getAllMissions() {
        return missionService.getAllMissions();
    }
}
