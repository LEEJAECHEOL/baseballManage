package com.cos.baseball.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.domain.player.Player;
import com.cos.baseball.domain.player.dto.PlayerByPositionRespDto;
import com.cos.baseball.domain.player.dto.PlayerSaveReqDto;
import com.cos.baseball.domain.team.Team;
import com.cos.baseball.domain.team.dto.TeamSaveReqDto;
import com.cos.baseball.query.PositionQuery;
import com.cos.baseball.service.PlayerService;
import com.cos.baseball.service.TeamService;
import com.cos.baseball.util.Script;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {
	

	private final TeamService teamService;
	private final PlayerService playerService;
	private final PositionQuery positionQuery;
	
	@GetMapping("/position")
	public String byPosition(Model model) {
		JpaResultMapper jpaResultMapper = new JpaResultMapper();
		List<PlayerByPositionRespDto> myDtos = jpaResultMapper.list(positionQuery.positionPivot(), PlayerByPositionRespDto.class);
		model.addAttribute("dto", myDtos);
		System.out.println(myDtos);
		return "list";
	}

	@GetMapping("/player")
	public String list(Model model) {
		List<Player> entity = playerService.전체가져오기();
		model.addAttribute("dto", entity);
		return "player/list";
	}
	
	@GetMapping("/player/saveForm")
	public String saveForm(Model model, HttpServletResponse response) {
		List<Team> entity = teamService.전체가져오기();
		if(entity.size() == 0) {
			Script.back(response, "팀을 등록 후 등록이 가능합니다.");
		}
		model.addAttribute("dto", entity);
		return "player/saveForm";
	}
	
	@PostMapping("/player")
	public String save(String name,String position, int teamId) {
		PlayerSaveReqDto dto = new PlayerSaveReqDto();
		dto.setName(name);
		dto.setPosition(position);
		dto.setTeamId(teamId);
		playerService.저장하기(dto.toEntity());
		return "redirect:/player";
	}

	
	@DeleteMapping("/player/{id}")
	public @ResponseBody String delete(@PathVariable Integer id) {
		playerService.삭제하기(id);
		return "ok";
	}
}
