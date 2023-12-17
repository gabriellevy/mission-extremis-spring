package fr.mdeharbe.missionextremis;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EquipeRepository extends ReactiveCrudRepository<Equipe, String> {
}