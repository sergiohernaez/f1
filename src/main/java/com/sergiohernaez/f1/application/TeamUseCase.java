package com.sergiohernaez.f1.application;

import com.sergiohernaez.f1.domain.Team;
import com.sergiohernaez.f1.infrastructure.TeamMapper;
import com.sergiohernaez.f1.infrastructure.TeamRepository;
import com.sergiohernaez.f1.presentation.TeamDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@AllArgsConstructor
public class TeamUseCase {

    public TeamRepository teamRepository;
    public TeamMapper teamMapper;

    public List<TeamDTO> getTeams() {
        return teamRepository.findAll().stream().map(team -> teamMapper.teamToDto(team)).toList();
    }

    public Boolean addTeam(TeamDTO teamDTO) {
        try {
            if(validateYear(teamDTO.getYearOfCreation()) && Objects.isNull(teamDTO.getId())) {
                Team team = teamMapper.dtoToTeam(teamDTO);
                teamRepository.save(team);
                return true;
            }
            return false;
        } catch(Exception ex) {
            return false;
        }
    }

    public Boolean updateTeam(TeamDTO teamDTO) {
        try {
            Optional<Team> team = teamRepository.findById(teamDTO.getId());
            if(team.isPresent() && validateYear(teamDTO.getYearOfCreation())) {
                teamRepository.save(teamMapper.dtoToTeam(teamDTO));
                return true;
            }
            return false;

        } catch (Exception ex) {
            return false;
        }
    }

    public Boolean deleteTeam(Long teamId) {
        try {
            teamRepository.deleteById(teamId);
            return true;
        }catch(Exception ex) {
            return false;
        }
    }

    private boolean validateYear(String year) {
        return year.matches("(?:18|19|20|21)[0-9]{2}");
    }
}
