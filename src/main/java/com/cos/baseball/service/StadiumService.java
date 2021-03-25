package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.baseball.domain.stadium.Stadium;
import com.cos.baseball.domain.stadium.StadiumRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StadiumService {

	private final StadiumRepository stadiumRepository;
	
	@Transactional(readOnly = true)
	public List<Stadium> 전체가져오기(){
		return stadiumRepository.findAll();
	}
	@Transactional
	public Stadium 저장하기(Stadium stadium) {
		return stadiumRepository.save(stadium);
	}
	@Transactional
	public void 삭제하기(Integer id) {
		stadiumRepository.deleteById(id);
	}
	
}
