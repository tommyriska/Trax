package dev.riska.trax.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoders;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig {

    @Value("${spring.security.oauth2.resourceserver.jwk.issuer-uri}")
    private String issuerUri;

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .authorizeExchange()
//                .pathMatchers(HttpMethod.GET, "/user/**").permitAll()
//                .pathMatchers(HttpMethod.GET, "/api/user/**").permitAll()
//                .pathMatchers(HttpMethod.POST, "/user/**").permitAll()
//                .pathMatchers(HttpMethod.POST, "/api/user/**").permitAll()
                .anyExchange().authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }

    @Bean
    public ReactiveJwtDecoder jwtDecoder() {
        return ReactiveJwtDecoders.fromOidcIssuerLocation(issuerUri);
    }

}
