package com.cos.movie.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.movie.domain.CommonDto;
import com.cos.movie.domain.Movie;
import com.cos.movie.domain.MovieRepository;
import com.cos.movie.domain.PostReqDto;
import com.cos.movie.domain.UpdateReqDto;

@RestController
public class MovieController {
	private MovieRepository movieRepository;
	
	public MovieController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	@GetMapping("/movie")
	public List<Movie> findAll(){
		System.out.println("findAll()");
		return movieRepository.findAll();
	}
	
	@GetMapping("/movie/{id}")
	public Movie findById(@PathVariable int id) {
		System.out.println("findById()");
		return movieRepository.findById(id);
		//JSON String 으로 반환되는중.
	}
	
	@PostMapping("/movie")
	public CommonDto<?> post(@Valid @RequestBody PostReqDto dto, BindingResult bindingResult){
		
		System.out.println("post()");
		System.out.println("movie: "+ dto);
		return new CommonDto<>(HttpStatus.CREATED.value(),"ok");
	}
	
	@DeleteMapping("/movie/{id}")  //@PathVariable붙은 인자의 이름과 정확히 일치해야 바인딩 됨
	public CommonDto delete(@PathVariable int id) {
		System.out.println("delete()");
		movieRepository.delete(id);
		return new CommonDto<>(HttpStatus.OK.value(),"ok");
		
	}
	
	@PutMapping("/movie/{id}") // 업데이트 할 정보(ReqDto= title, rating)를 인자에 넣는다.
	public CommonDto update(@PathVariable int id,@Valid @RequestBody UpdateReqDto dto, BindingResult bindingResult) {
		System.out.println("update()");
		movieRepository.update(id, dto); 
		return new CommonDto<>(HttpStatus.OK.value(),"ok"); 
	}
	
	
}
