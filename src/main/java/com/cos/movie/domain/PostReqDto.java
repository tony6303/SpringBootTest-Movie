package com.cos.movie.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PostReqDto {
	@NotNull(message = "제목이 없습니다.")
	@NotBlank(message = "제목이 없습니다.")
	private String title;
	
	private double rating;
}
