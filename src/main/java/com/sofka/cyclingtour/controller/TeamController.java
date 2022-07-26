package com.sofka.cyclingtour.controller;

import com.sofka.cyclingtour.dto.TeamDto;
import com.sofka.cyclingtour.entity.Team;
import com.sofka.cyclingtour.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("*")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/teams")
    public List<TeamDto> getAllTeams() {
        return teamService.getAllTeams();
    }

    @PostMapping("/teams")
    public TeamDto saveTeam(@RequestBody TeamDto teamDto) {
        return teamService.saveTeam(teamDto);
    }

    @PutMapping("/teams")
    public TeamDto updateTeam(@RequestBody TeamDto teamDto) {
        return teamService.updateTeam(teamDto);
    }

    @DeleteMapping("/teams/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }
}
