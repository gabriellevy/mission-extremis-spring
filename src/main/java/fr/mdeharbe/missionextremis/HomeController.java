package fr.mdeharbe.missionextremis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// entrée de base de la page (http://localhost:8080/)
@RestController
public class HomeController {

    @GetMapping
    public String choixMission(@RequestParam(required = false, defaultValue = "") String idMission) {
        return idMission.isEmpty() ?
                "Accueil mais qui ne sert à rien pour l'instant (rediriger vers choix d'une mission ?)" :
                "Lancement de la mission, " + idMission + "!";
    }
}
