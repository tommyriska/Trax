package dev.riska.trax.rest;

import dev.riska.trax.model.User;
import dev.riska.trax.model.request.CreateUserRequest;
import dev.riska.trax.repository.UserRepository;
import dev.riska.trax.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("{id}")
    public Mono<ResponseEntity<User>> getUser(@PathVariable String id) {
        log.info("Searching for user with id " + id);
        return userRepository.findById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Object>> createUser(@RequestBody CreateUserRequest user) {
        return userService.createUser(user)
                .map(s -> ResponseEntity.created(UriComponentsBuilder.fromPath("/user/{id}").buildAndExpand(s).toUri()).build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
