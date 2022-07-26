package com.sofka.cyclingtour.mapper;

import com.sofka.cyclingtour.dto.TeamDto;
import com.sofka.cyclingtour.entity.Team;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface TeamMapper {
    TeamDto teamToTeamDto(Team team);

    Team teamDtoToTeam(TeamDto teamDto);

    List<TeamDto> teamListToTeamDtoList(List<Team> team);

    List<Team> teamDtoListToTeamList(List<TeamDto> teamDtos);
}
