package com.sergiohernaez.f1.presentation;

import com.sergiohernaez.f1.application.TeamUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TeamController {

    TeamUseCase teamUseCase;

    @GetMapping("/teams")
    public List<TeamDTO> getTeams() {
        return teamUseCase.getTeams();
    }

    @PostMapping("/team")
    public ResponseEntity<String> addTeam(@RequestBody TeamDTO teamDTO) {
        if(teamUseCase.addTeam(teamDTO)) return new ResponseEntity<>("Added",HttpStatus.OK);
        else return new ResponseEntity<>("Could not be added",HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/team")
    public ResponseEntity<String> updateTeam(@RequestBody TeamDTO teamDTO) {
        if(teamUseCase.updateTeam(teamDTO)) return new ResponseEntity<>("Updated",HttpStatus.OK);
        else return new ResponseEntity<>("Could not be updated",HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/team/{id}")
    public ResponseEntity<String> deleteTeam(@PathVariable Long teamId) {
        if(teamUseCase.deleteTeam(teamId)) return new ResponseEntity<>("Deleted",HttpStatus.OK);
        else return new ResponseEntity<>("Could not be deleted",HttpStatus.BAD_REQUEST);
    }


}
