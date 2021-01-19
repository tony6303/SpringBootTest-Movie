package com.cos.movie.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {	
	

	public List<Movie> findAll(){
		List<Movie> movies = new ArrayList<>();
		Timestamp now = Timestamp.valueOf(LocalDateTime.now());
		movies.add(new Movie(1,"Find the Nimo",8.9,now));
		movies.add(new Movie(2,"Jaws",9.9,now));
		movies.add(new Movie(3,"Harry Poter",7.5,now));
		
		return movies;
	}
	
	public Movie findById(int id) {
		Timestamp now = Timestamp.valueOf(LocalDateTime.now());
		return new Movie(1,"Find the Nimo",8.9,now);
	}
	
	public void post(PostReqDto dto) {
		System.out.println("영화 등록 성공");
	}
	
	public void delete(int id) {
		System.out.println("영화 삭제 성공");
	}
	
	public void update(int id, UpdateReqDto dto) {
		System.out.println("영화 수정 성공");
	}
}
