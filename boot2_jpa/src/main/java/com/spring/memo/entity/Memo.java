package com.spring.memo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@SequenceGenerator(name="mem_seq_gen", sequenceName = "mem_seq",allocationSize = 1)
@ToString@Getter@Setter@AllArgsConstructor@NoArgsConstructor
@Entity //클래스를 엔티티로 선언
//@Table(name="memos")
@Builder
public class Memo {

	
	// name : 임의로 이름 설정(필수), sequenceName : mem_seq.nextval, allocationSize = 증가할 숫자 (지정안하면 50씩 증가)
	//@SequenceGenerator(name="mem_seq_gen", sequenceName = "mem_seq",allocationSize = 1)
	
	//GenerationType : 1) AUTO : JPA 구현체가 자동으로 구현, 2) IDENTITY : 기본키 생성을 데이터베이스에 위임
//					   3) SEQUENCE :@SequenceGenerator 등록 후 사용
//					   4) TABLE : 키 생성용 테이블 사용 @TableGenerator사용
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "")
	@Id //pk로 생성하라는 뜻
	private Long mno;
	
	@Column(length = 200, nullable = false)
	private String memoText;
}
