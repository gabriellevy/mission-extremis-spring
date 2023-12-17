package fr.mdeharbe.missionextremis;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EvtRepository extends ReactiveCrudRepository<Mission, String> {
}
