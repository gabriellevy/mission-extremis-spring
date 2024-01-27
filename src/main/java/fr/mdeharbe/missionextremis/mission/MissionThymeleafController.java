package fr.mdeharbe.missionextremis.mission;

import fr.mdeharbe.missionextremis.equipe.perso.PersoService;
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
    private final PersoService persoService;


    @Autowired
    public MissionThymeleafController(MissionService missionService,  PersoService persoService) {
        this.missionService = missionService;
        this.persoService = persoService;
    }

    @GetMapping("/missions-ui")
    public Mono<String> missions(Model model) {
        model.addAttribute("missions", missionService.getAllMissions());
        return Mono.just("missions");
    }


    // exécuter une mission avec une équipe particulière
    @GetMapping(value = {"/preparer-mission/{idMission}", "/preparer-mission"})
    public Mono<String> executerMission(@PathVariable("idMission") String idMission,
                                  Model model) {
        Mono<Mission> mission = missionService.findMissionById(idMission);
        model.addAttribute("mission", mission);
        model.addAttribute("persos", persoService.getAllPersos());
        return Mono.just("preparer-mission");
    }
}
