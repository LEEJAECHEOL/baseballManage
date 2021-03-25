package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cos.baseball.domain.stadium.Stadium;
import com.cos.baseball.domain.stadium.StadiumRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StadiumService {

	private final StadiumRepository stadiumRepository;
	
	public List<Stadium> 전체가져오기(){
		return stadiumRepository.findAll();
	}
	
	public Stadium 저장하기(Stadium stadium) {
		return stadiumRepository.save(stadium);
	}
	public void 삭제하기(Integer id) {
		stadiumRepository.deleteById(id);
	}
	
}
