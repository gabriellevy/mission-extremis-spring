package fr.mdeharbe.missionextremis.mission;

import fr.mdeharbe.missionextremis.equipe.Equipe;
import fr.mdeharbe.missionextremis.equipe.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * controller servant à l'affichage
 */
@RestController
public class MissionThymeleafController {
    private final EquipeRepository equipeRepo;
    private final MissionService missionService;

    @Autowired
    public MissionThymeleafController(EquipeRepository equipeRepo, MissionService missionService) {
        this.equipeRepo = equipeRepo;
        this.missionService = missionService;
    }

    @GetMapping("/missions-ui")
    public String missions(Model model) {
        model.addAttribute("missions", missionService.getAllMissions());
        return "missions";
    }


    // exécuter une mission avec une équipe particulière
    @GetMapping(value = {"/executer-mission/{idMission}/{idEquipe}", "/executer-mission"})
    public String executerMission(@PathVariable("idMission") String idMission,
                                  @PathVariable("idEquipe") String idEquipe,
                                  Model model) {
        Mono<Mission> mission = missionService.findMissionById(idMission);
        Mono<Equipe> equipe = equipeRepo.findById(idEquipe);
        model.addAttribute("mission", mission);
        model.addAttribute("equipe", equipe);
        return "executer-mission";
    }
}
