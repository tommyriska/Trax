DELETE FROM `Match`;
DELETE FROM Team;
DELETE FROM `User`;

INSERT INTO `User` (idUser, firstName, lastName, dateCreated, authmethod, lastLogin) VALUES (uuid(), "Tommy", "Riska", now(), "Google", now());
INSERT INTO `User` (idUser, firstName, lastName, dateCreated, authmethod, lastLogin) VALUES (uuid(), "Vetle", "Horpestad", now(), "Google", now());

INSERT INTO Team (idTeam, teamName, manager, dateCreated) VALUES (uuid(), "Best Uten Ball FC", (select idUser from User where firstName = "Tommy"), now());
INSERT INTO Team (idTeam, teamName, manager, dateCreated) VALUES (uuid(), "Manu FC", (select idUser from User where firstName = "Vetle"), now());

INSERT INTO `Match` (idMatch, homeTeam, awayTeam, homeTeamGoals, awayTeamGoals, matchDate) VALUES (uuid(), (select idTeam from Team where teamName = "Best Uten Ball FC"), (select idTeam from Team where teamName = "Manu FC"), 5, 0, now());
