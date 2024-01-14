package fr.mdeharbe.missionextremis.mission;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MissionRepository extends ReactiveCrudRepository<Mission, String> {
}
