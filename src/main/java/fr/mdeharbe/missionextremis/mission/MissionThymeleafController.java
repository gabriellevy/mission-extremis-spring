package fr.mdeharbe.missionextremis.mission;

import fr.mdeharbe.missionextremis.equipe.perso.PersoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

import static fr.mdeharbe.missionextremis.ReglesEtConstantes.MAX_PERSO_NUM;

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


    // préparer l'exécution d'une mission en sélectionnant des persos
    @GetMapping(value = {"/ajouter-perso/mission/{idMission}/perso/{idPerso}", "/ajouter-perso"})
    public Mono<String> ajouterPerso(@PathVariable("idMission") String idMission,
                                        @PathVariable("idPerso") String idPerso,
                                        Model model) {
        return persoService.getAllPersosSelectionnes()
                .collectList()
                .flatMap(
                    persoSel -> {

                        if (persoSel.size() < MAX_PERSO_NUM) {
                            return persoService.selectionnePerso(idPerso)
                                    .then(addBaseDataToModels(idMission, model))
                                    .thenReturn("preparer-mission");
                        } else {
                            return addBaseDataToModels(idMission, model)
                                    .thenReturn("preparer-mission");
                        }
                        });
    }

    @GetMapping(value = {"/retirer-perso/mission/{idMission}/perso/{idPerso}", "/retirer-perso"})
    public Mono<String> retirerPerso(@PathVariable("idMission") String idMission,
                                        @PathVariable("idPerso") String idPerso,
                                        Model model) {
        return persoService.deSelectionnePerso(idPerso)
                .then(addBaseDataToModels(idMission, model))
                        .thenReturn("preparer-mission");
    }

    // exécution d'une mission avec m'équipe actuellement sélectionnée
    @GetMapping(value = {"/preparer-mission/{idMission}", "/preparer-mission"})
    public Mono<String> preparerMission(@PathVariable("idMission") String idMission,
                                  Model model) {
        return addBaseDataToModels(idMission, model).
                thenReturn("preparer-mission");
    }

    // exécution d'une mission avec l'équipe actuellement sélectionnée
    @GetMapping(value = {"/executer-mission/mission/{idMission}", "/executer-mission"})
    public Mono<String> executerMission(@PathVariable("idMission") String idMission,
                                        Model model) {
        return addBaseDataToModels(idMission, model).
            thenReturn("executer-mission");
    }

    private Mono<Void> addBaseDataToModels(String idMission, Model model) {
        Mono<Mission> mission = missionService.findMissionById(idMission);
        model.addAttribute("mission", mission);
        model.addAttribute("persosDispos", persoService.getAllPersosDispos());
        model.addAttribute("persosSelectionnes", persoService.getAllPersosSelectionnes());
        return persoService.getAllPersosSelectionnes().collectList()
                .flatMap(
                        persoSel -> {
                                model.addAttribute("selectionnables",
                                        persoSel.size() < MAX_PERSO_NUM);
                                return Mono.empty();
                            });
    }
}
