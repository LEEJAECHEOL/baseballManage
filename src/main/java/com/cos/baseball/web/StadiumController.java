package com.cos.baseball.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.baseball.domain.stadium.Stadium;
import com.cos.baseball.domain.stadium.dto.StadiumSaveReqDto;
import com.cos.baseball.service.StadiumService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class StadiumController {
	
	private final StadiumService stadiumService;
	
	@GetMapping("/stadium")
	public String findAll(Model model) {
		List<Stadium> entity =stadiumService.전체가져오기();
		model.addAttribute("dto", entity);
		return "stadium/list";
	}
	
	@GetMapping("/stadium/saveForm")
	public String saveForm() {
		return "stadium/saveForm";
	}
	
	@PostMapping("/stadium")
	public String save(String name) {
		StadiumSaveReqDto dto = new StadiumSaveReqDto();
		dto.setName(name);
		stadiumService.저장하기(dto.toEntity());
		return "redirect:/stadium";
	}
	
	
	@DeleteMapping("/stadium/{id}")
	public @ResponseBody String delete(@PathVariable Integer id) {
		stadiumService.삭제하기(id);
		return "ok";
	}
}
