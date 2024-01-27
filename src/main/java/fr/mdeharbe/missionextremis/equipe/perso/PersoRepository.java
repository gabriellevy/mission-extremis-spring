package fr.mdeharbe.missionextremis.equipe.perso;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PersoRepository extends ReactiveCrudRepository<Perso, String> {
}