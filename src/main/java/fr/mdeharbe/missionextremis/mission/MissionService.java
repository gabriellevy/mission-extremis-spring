package fr.mdeharbe.missionextremis.mission;

import fr.mdeharbe.missionextremis.equipe.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class MissionService {
    final private MissionRepository repo;

    @Autowired
    public MissionService(MissionRepository repo) {
        this.repo = repo;
    }

    public Mono<Mission> saveMission(Mission mission){
        return repo.save(mission);
    }

    public Flux<Mission> getAllMissionsFlux(){
        return repo.findAll();
    }
    public Iterable<Mission> getAllMissions(){
        return repo.findAll().toIterable();
    }

    public void deleteAllMissions(){
        repo.deleteAll();
    }

    public void deleteMissionById(String id){
        repo.deleteById(id);
    }

    public Mono<Mission> findMissionById(String id){
        return repo.findById(id);
    }
    public String executerMission(Mono<Mission> mission, Mono<Equipe> equipe) {
        return "L'équipe " +
                Objects.requireNonNull(equipe.block()).getName() +
                " se lance dans la mission " +
                Objects.requireNonNull(mission.block()).getName();
    }
}
