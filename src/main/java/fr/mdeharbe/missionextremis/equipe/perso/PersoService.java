package fr.mdeharbe.missionextremis.equipe.perso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersoService {
    final private PersoRepository repo;

    @Autowired
    public PersoService(PersoRepository repo) {
        this.repo = repo;
    }

    public Mono<Perso> savePerso(Perso perso){
        return repo.save(perso);
    }

    public void selectionnePerso(String idPerso){
        findPersoById(idPerso).map(perso -> {
            perso.setSelectionne(true);
            return perso;
        }).flatMap(repo::save)
                .subscribe(System.out::println);
    }

    public Flux<Perso> getAllPersos(){
        return repo.findAll();
    }
    public Flux<Perso> getAllPersosDispos(){
        return repo.findAll().filter(perso -> !perso.getSelectionne());
    }
    public Flux<Perso> getAllPersosSelectionnes(){
        return repo.findAll().filter(Perso::getSelectionne);
    }

    public void deleteAllPersos(){
        repo.deleteAll();
    }

    public void deletePersoById(String id){
        repo.deleteById(id);
    }

    public Mono<Perso> findPersoById(String id){
        return repo.findById(id);
    }
}
