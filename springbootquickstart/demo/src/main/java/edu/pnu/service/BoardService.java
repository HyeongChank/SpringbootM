package edu.pnu.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.Person;

@Service
public class BoardService {
	private List<Person> list = new ArrayList<>();
	public BoardService() {
		int i =0;
		System.out.println("==========생성=========" + i);
		i++;
		list.add(new Person("홍길동", 2000, "dkf", "선물"));
		list.add(new Person("홍길동", 2000, "dkf", "선물"));		
	}
	public List<Person> getPersons(){
		return list;
	}
}
