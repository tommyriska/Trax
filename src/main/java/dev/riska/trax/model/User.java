package dev.riska.trax.model;

import dev.riska.trax.model.request.CreateUserRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("User")
public class User {
    @Id
    @Column("idUser")
    private String idUser;
    @Column("firstName")
    private String firstName;
    @Column("lastName")
    private String lastName;
    @Column("dateCreated")
    private LocalDateTime dateCreated;
    @Column("authMethod")
    private String authMethod;
    @Column("lastLogin")
    private Instant lastLogin;
    @Transient

    public static User createNewUser(CreateUserRequest userReq, String authMethod) {
        User user = new User();
        user.setFirstName(userReq.getFirstName());
        user.setLastName(userReq.getLastName());
        user.setDateCreated(LocalDateTime.now());
        user.setAuthMethod(authMethod);
        user.setLastLogin(Instant.now());
        return user;
    }
}
