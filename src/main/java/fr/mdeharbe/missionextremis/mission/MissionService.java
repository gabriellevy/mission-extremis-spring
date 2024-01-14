package fr.mdeharbe.missionextremis.mission;

import fr.mdeharbe.missionextremis.equipe.Equipe;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class MissionService {
    public String executerMission(Mono<Mission> mission, Mono<Equipe> equipe) {
        return "L'équipe " +
                equipe.block().getName() +
                " se lance dans la mission " +
                mission.block().getName();
    }
}
