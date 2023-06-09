package com.spring.memo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.memo.entity.Member;

@SpringBootTest
public class MemberRepositoryTest {
	@Autowired
	private MemberRepository repository;
	
	@Test
	public void createMember() {
		Member member = Member.builder()
							.name("성춘향")
							.email("sung@naver.com")
							.password("sung123")
							.address("서울종로구을지로")
							.build();
				
		repository.save(member);
	}
}
