package com.sergiohernaez.f1;

import com.sergiohernaez.f1.domain.Team;
import com.sergiohernaez.f1.presentation.TeamDTO;

import java.time.LocalDate;

public class TestUtils {

    public static Team getTeam() {
        return Team.builder().id(1L).name("Example0").dateOfCreation(LocalDate.now()).championshipsWon(1L).entryFeePaid(true).build();
    }

    public static Team getTeamWithoutId() {
        return Team.builder().id(null).name("Example0").dateOfCreation(LocalDate.now()).championshipsWon(1L).entryFeePaid(true).build();
    }

    public static TeamDTO getTeamDto() {
        return TeamDTO.builder().id(1L).name("Example0").yearOfCreation(String.valueOf(LocalDate.now().getYear())).championshipsWon(1L).entryFeePaid(true).build();
    }

    public static TeamDTO getTeamDtoWithoutId() {
        return TeamDTO.builder().id(null).name("Example0").yearOfCreation(String.valueOf(LocalDate.now().getYear())).championshipsWon(1L).entryFeePaid(true).build();
    }
}
