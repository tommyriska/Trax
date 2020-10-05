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
@Table("Match")
public class Match {
    @Id
    @Column("idMatch")
    private UUID idMatch;
    @Column("homeTeam")
    private UUID homeTeam;
    @Column("awayTeam")
    private UUID awayTeam;
    @Column("homeTeamGoals")
    private int homeTeamGoals;
    @Column("awayTeamGoals")
    private int awayTeamGoals;
    @Column("matchDate")
    private LocalDateTime matchDate;
}
