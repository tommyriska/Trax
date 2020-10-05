package dev.riska.trax.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("Team")
public class Team {
    @Id
    @Column("idUser")
    private UUID idUser;
    @Column("teamName")
    private String teamName;
    @Column("manager")
    private UUID manager;
    @Column("dateCreated")
    private LocalDateTime dateCreated;
}
