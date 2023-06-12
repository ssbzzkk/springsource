package com.example.restaurant.naver.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//검색 요청 시 응답 데이터 담을 객체

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SearchLocalRes {
	private String lastBuildDate;
	private int total;
	private int start;
	private int display;
	private List<SearchLocalItem> items;
	
//	lastBuildDate": "Mon, 12 Jun 2023 10:57:40 +0900",
//	"total": 1,
//	"start": 1,
//	"display": 1,
//	"items":[  ]
	
}
