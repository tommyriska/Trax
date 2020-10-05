package dev.riska.trax.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

@SpringBootTest
public class TeamRepositoryTests {

    @Autowired
    TeamRepository teamRepository;

    @Test
    public void whenDeleteAll_then0IsExpected() {
        teamRepository.deleteAll()
                .as(StepVerifier::create)
                .expectNextCount(0)
                .verifyComplete();
    }

}
