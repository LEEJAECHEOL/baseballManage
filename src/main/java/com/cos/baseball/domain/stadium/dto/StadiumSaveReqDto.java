package com.cos.baseball.domain.stadium.dto;

import com.cos.baseball.domain.stadium.Stadium;

import lombok.Data;

@Data
public class StadiumSaveReqDto {
	private String name;
	
	public Stadium toEntity() {
		return Stadium.builder().name(name).build();
	}
}
