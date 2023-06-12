package com.example.restaurant.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchImageItem {

	private String title;			//이미지가 검색된 문서의 제목
	private String link;			//이미지의 URL
	private String thumbnail;		//섬네일 이미지의 URL
	private String sizeheight;		//이미지의 세로 크기(단위: 픽셀)
	private String sizewidth;		//이미지의 가로 크기(단위: 픽셀)
	
	
//	"title": "혹시 이사진만보고 어디 돼지갈비집인지 알수있을까요? | 보배드림 자유게시판",
//	"link": "https://file1.bobaedream.co.kr/bbs/freeb/2022/01/01/19/qtwk1641031473_1925313832.jpg",
//	"thumbnail": "https://search.pstatic.net/sunny/?type=b150&src=https://file1.bobaedream.co.kr/bbs/freeb/2022/01/01/19/qtwk1641031473_1925313832.jpg",
//	"sizeheight": "806",
//	"sizewidth": "800"
}
