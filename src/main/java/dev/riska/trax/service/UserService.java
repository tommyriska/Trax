package dev.riska.trax.service;


import dev.riska.trax.model.request.CreateUserRequest;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<String> createUser(CreateUserRequest userReq);
}
