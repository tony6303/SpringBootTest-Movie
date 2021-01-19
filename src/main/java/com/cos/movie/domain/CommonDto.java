package com.cos.movie.domain;

import com.cos.movie.domain.CommonDto;

import lombok.Data;

@Data
public class CommonDto<T> {
	private int statusCode;
	private T data;
	
	
	public CommonDto(int statusCode, T data) {
		super();
		this.statusCode = statusCode;
		this.data = data;
	}
	
	public CommonDto(int statusCode) {
		super();
		this.statusCode = statusCode;
	}
}
