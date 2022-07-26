package com.sofka.cyclingtour.service;

import com.sofka.cyclingtour.dto.TeamDto;

import java.util.List;

public interface TeamService {

    List<TeamDto> getAllTeams();

    TeamDto saveTeam(TeamDto teamDto);

    TeamDto updateTeam(TeamDto teamDto);

    void deleteTeam(Long id);
}
