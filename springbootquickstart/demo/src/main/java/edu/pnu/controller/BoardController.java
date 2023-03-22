package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Person;
import edu.pnu.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
//	BoardService boardservice = new BoardService();
	
	public BoardController() {
		System.out.println("===> BoardController 생성");

	}
	@GetMapping("/hello")
	public String hello(String name) {
		return "hello : " + name;
	}
	@PostMapping("/hello")
	public String hello2(String name) {

		return "hellopost : " + name;
	}
	@GetMapping("/getPerson")
	public Person getPerson() {
		return new Person("홍길동", 2000, "dkf", "선물");
	}
	@GetMapping("/getPersons")
	public List<Person> getPersons(){
		BoardService boardService = new BoardService();
		return boardService.getPersons();
		
	}

}
