package com.sergiohernaez.f1.infrastructure;

import com.sergiohernaez.f1.domain.Team;
import com.sergiohernaez.f1.presentation.TeamDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TeamMapper {

    public TeamDTO teamToDto(Team team) {
        return TeamDTO.builder().id(team.getId()).name(team.getName()).yearOfCreation(team.getYearOfCreation())
                .championshipsWon(team.getChampionshipsWon()).entryFeePaid(team.getEntryFeePaid()).build();
    }

    public Team dtoToTeam(TeamDTO teamDto) {
        LocalDate date = LocalDate.of(Integer.parseInt(teamDto.getYearOfCreation()),1,1);
        return Team.builder().id(teamDto.getId()).name(teamDto.getName()).dateOfCreation(date)
                .championshipsWon(teamDto.getChampionshipsWon()).entryFeePaid(teamDto.getEntryFeePaid()).build();
    }
    }
