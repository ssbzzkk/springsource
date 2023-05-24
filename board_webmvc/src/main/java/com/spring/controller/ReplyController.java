package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.domain.Criteria;
import com.spring.domain.ReplyDTO;
import com.spring.service.ReplyService;

import lombok.extern.slf4j.Slf4j;

// http://localhost:8080/replies/


@Slf4j
@Controller
@RequestMapping("/replies")
public class ReplyController {

	@Autowired
	private ReplyService reService;

	//http://localhost:8080/replies/1 + GET : 1번 댓글 데이터 가져오기
	@GetMapping(value="/{rno}", produces=MediaType.APPLICATION_JSON_VALUE) //, produces=MediaType.APPLICATION_JSON_VALUE 는 없어도 됨
 	public ResponseEntity<ReplyDTO> get(@PathVariable("rno") int rno){
		log.info("댓글조회" +rno);
		
		return new ResponseEntity<ReplyDTO>(reService.read(rno),HttpStatus.OK);
	}
	
	// http://localhost:8080/replies/new + POST + 입력데이터(json)
	@PostMapping("/new")
	public ResponseEntity<String> create(@RequestBody ReplyDTO dto){
		log.info("댓글삽입");
		return reService.insert(dto)?
				new ResponseEntity<String>("success",HttpStatus.OK):
					new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// http://localhost:8080/replies/pages/bno/ + GET
	@GetMapping("/pages/{bno}/{page}")
	public ResponseEntity<List<ReplyDTO>> select(@PathVariable("bno") int bno,@PathVariable("page") int page){
		log.info("댓글조회"+bno);
		
		Criteria cri = new Criteria(page, 10);
		
		return new ResponseEntity<List<ReplyDTO>>(reService.getList(cri, bno),HttpStatus.OK);
	}
	
	// http://localhost:8080/replies/rno + PUT + 수정데이터(json)
	@PutMapping("/{rno}")
	public ResponseEntity<String> modify(@RequestBody ReplyDTO dto){
		log.info("댓글 수정 "+ dto);
		
		return reService.update(dto)?
			new ResponseEntity<String>("success",HttpStatus.OK):
				new ResponseEntity<String>("success",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	// http://localhost:8080/replies/rno + DELETE : 댓글 삭제
	@DeleteMapping("/{rno}")
	public ResponseEntity<String> remove(@PathVariable("rno") int rno){
		log.info("댓글삭제 "+rno);
		
		return reService.delete(rno)?
				new ResponseEntity<String>("success",HttpStatus.OK):
					new ResponseEntity<String>("success",HttpStatus.INTERNAL_SERVER_ERROR);
				

	}
	
	
}
