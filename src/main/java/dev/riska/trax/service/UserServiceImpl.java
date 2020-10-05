package dev.riska.trax.service;

import dev.riska.trax.model.request.CreateUserRequest;
import dev.riska.trax.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DatabaseClient databaseClient;

    @Override
    public Mono<String> createUser(CreateUserRequest userReq) {
        String newId = UUID.randomUUID().toString();
        return databaseClient.execute("INSERT INTO `User` (idUser, firstName, lastName, dateCreated, authMethod, lastLogin) VALUES (:idUser, :firstName, :lastName, :dateCreated, :authMethod, :lastLogin)")
                .bind("idUser", newId)
                .bind("firstName", userReq.getFirstName())
                .bind("lastName", userReq.getLastName())
                .bind("dateCreated", Instant.now())
                .bind("authMethod", "Google")
                .bind("lastLogin", Instant.now())
                .fetch()
                .rowsUpdated()
                .thenReturn(newId);
    }
}
