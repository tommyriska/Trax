package dev.riska.trax.repository;

import dev.riska.trax.model.Match;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.UUID;

public interface MatchRepository extends ReactiveCrudRepository<Match, UUID> {
}
