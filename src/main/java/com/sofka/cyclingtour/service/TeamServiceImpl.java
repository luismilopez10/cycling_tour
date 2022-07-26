package com.sofka.cyclingtour.service;

import com.sofka.cyclingtour.dto.TeamDto;
import com.sofka.cyclingtour.entity.Cyclist;
import com.sofka.cyclingtour.mapper.TeamMapper;
import com.sofka.cyclingtour.repository.CyclistRepository;
import com.sofka.cyclingtour.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    private CyclistRepository cyclistRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamMapper mapper;

    @Override
    public List<TeamDto> getAllTeams() {
        return mapper.teamListToTeamDtoList(teamRepository.findAll());
    }

    @Override
    public TeamDto saveTeam(TeamDto teamDto) {
        return mapper.teamToTeamDto(teamRepository.save(mapper.teamDtoToTeam(teamDto)));
    }

    @Override
    public TeamDto updateTeam(TeamDto teamDto) {
        return mapper.teamToTeamDto(teamRepository.save(mapper.teamDtoToTeam(teamDto)));
    }

    @Override
    public void deleteTeam(Long id) {
        List<Cyclist> cyclists = cyclistRepository.findByTeamId(id);
        if(cyclists.size() > 0){
            cyclists.forEach(cyclistsToDelete -> cyclistRepository.deleteById(cyclistsToDelete.getId()));
        }
        teamRepository.deleteById(id);
    }
}
