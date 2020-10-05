package dev.riska.trax.repository;

import dev.riska.trax.model.Team;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface TeamRepository extends ReactiveCrudRepository<Team, UUID> {
}
