package fr.mdeharbe.missionextremis;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MissionRepository extends ReactiveCrudRepository<Mission, String> {
}
