package fr.mdeharbe.missionextremis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// entrée de base de la page (http://localhost:8080/)
@RestController
public class HomeController {

    @GetMapping
    public String greeting(@RequestParam(required = false, defaultValue = "") String name) {
        return name.isEmpty() ? "Hey!" : "Hey, " + name + "!";
    }
}
