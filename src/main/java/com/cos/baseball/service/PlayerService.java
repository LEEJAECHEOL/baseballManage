package com.cos.baseball.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cos.baseball.domain.player.PlayRepository;
import com.cos.baseball.domain.player.Player;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {
	
	private final PlayRepository playRepository;
	
	
	public List<Player> 전체가져오기(){
		return playRepository.findAll();
	}
	
	public Player 저장하기(Player player) {
		return playRepository.save(player);
	}
	public void 삭제하기(Integer id) {
		playRepository.deleteById(id);
	}
}
