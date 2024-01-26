package fr.mdeharbe.missionextremis.mission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

/**
 * controller servant à l'affichage
 */
@Controller
public class MissionThymeleafController {
    private final MissionService missionService;


    @Autowired
    public MissionThymeleafController(MissionService missionService) {
        this.missionService = missionService;
    }

    @GetMapping("/missions-ui")
    public Mono<String> missions(Model model) {
        model.addAttribute("missions", missionService.getAllMissionsFlux());
        return Mono.just("missions");
    }


    // exécuter une mission avec une équipe particulière
    @GetMapping(value = {"/preparer-mission/{idMission}", "/preparer-mission"})
    public Mono<String> executerMission(@PathVariable("idMission") String idMission,
                                  Model model) {
        Mono<Mission> mission = missionService.findMissionById(idMission);
        model.addAttribute("mission", mission);
        return Mono.just("preparer-mission");
    }
}
