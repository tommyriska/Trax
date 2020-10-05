package dev.riska.trax.repository;

import dev.riska.trax.model.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface UserRepository extends R2dbcRepository<User, String> {

}
