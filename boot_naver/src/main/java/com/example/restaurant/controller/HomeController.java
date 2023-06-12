package com.example.restaurant.controller;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	//main
	@GetMapping("/")
	public String home() {
		log.info("main 요청");
		return "main";	
	}
	
	@GetMapping("/api/server/naver")
	public String naver() {	
		log.info("네이버 검색 요청");
		
		URI uri = UriComponentsBuilder.fromUriString("")
									.path(null)
									.queryParam("query", "갈비집")
									.queryParam("display", "갈비집")
									.queryParam("start", "1")
									.queryParam("sort", "random")
									.encode()
									.build()
									.toUri();
		log.info("URI : "+uri);
			
		//헤더추가
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("", "");
//		headers.set("", "");
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		
//		HttpEntity<HttpHeaders> httpEntity = new HttpEntity<HttpHeaders>(headers);
		
		RequestEntity<Void> req = RequestEntity.get(uri)
												.header("X-Naver-Client-Id", "HTaiZ8lMR5LPQ8AV9BEP")
												.header("X-Naver-Client-Secret", "EXv6C_gMsT")
												.build();
		
		ResponseEntity<String> result = new RestTemplate().exchange(req, String.class);
		return result.getBody();
	}
}











