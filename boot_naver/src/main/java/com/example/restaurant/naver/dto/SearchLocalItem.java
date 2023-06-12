package com.example.restaurant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchLocalItem {

	private String title;			//업체, 기관명
	private String link;			//업체, 기관의 상세 정보 URL
	private String category;		//업체, 기관의 분류 정보
	private String description;		//업체, 기관에 대한 설명
	private String address;			//업체, 기관명의 지번 주소
	private String roadAddress;		//업체, 기관명의 도로명 주소
	private String mapx;			//업체, 기관이 위치한 장소의 x 좌표
	private String mapy;			//업체, 기관이 위치한 장소의 y 좌표
	
//	"title": "원조이동김미자할머니갈비 포천이동본점",
//	"link": "http://www.김미자할머니갈비.kr/",
//	"category": "한식>육류,고기요리",
//	"description": "",
//	"telephone": "",
//	"address": "경기도 포천시 이동면 장암리 216-3",
//	"roadAddress": "경기도 포천시 이동면 화동로 2087",
//	"mapx": "344545",
//	"mapy": "603667
}
