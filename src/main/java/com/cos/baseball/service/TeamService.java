package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cos.baseball.domain.team.Team;
import com.cos.baseball.domain.team.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamService {
	
	private final TeamRepository teamRepository;
	
	
	public List<Team> 전체가져오기(){
		return teamRepository.findAll();
	}
	
	public Team 저장하기(Team team) {
		return teamRepository.save(team);
	}
	public void 삭제하기(Integer id) {
		teamRepository.deleteById(id);
	}
	

}
