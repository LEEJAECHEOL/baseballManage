package com.cos.baseball.domain.team.dto;

import com.cos.baseball.domain.stadium.Stadium;
import com.cos.baseball.domain.team.Team;

import lombok.Data;

@Data
public class TeamSaveReqDto {
	private String name;
	private Integer stadiumId;
	
	public Team toEntity() {
		return Team.builder().name(name).stadium(Stadium.builder().id(stadiumId).build()).build();
	}
}
