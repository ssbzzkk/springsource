package com.spring.memo.repository;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.memo.entity.Memo;



@SpringBootTest
public class MemoRepositoryTest {

	@Autowired
	private MemoRepository memoRepository;
	
//	@Test
//	public void createMemoTest() {
//		
//		Memo memo = new Memo();
//		memo.setMemoText("메모 첫번재");
//		
//		//save() : insert, update
//		memoRepository.save(memo);
		
//		for(int i=0; i<100; i++) {
//			Memo memo=new Memo();
//			memo.setMemoText("Memo..."+i);
//			memoRepository.save(memo);
//	
//			Memo memo = Memo.builder()
//							.memoText("memo..."+i)
//							.build();
//			memoRepository.save(memo);
//			
//		}
//	}
//	@Test
//	public void findByMemo() {
//		//조회 : ifndById() 이미 있음
//		Optional<Memo> result=memoRepository.findById(90L);
//		
//		if(result.isPresent()) {
//			System.out.println(result.get());
//		}
//	}
//	
//	@Test
//	public void findByMemoList() {
//		//조회 : ifndById() 이미 있음
//		java.util.List<Memo> result=memoRepository.findAll();
//		
//		result.forEach(memo->System.out.println(memo));		
//	}
	
//	@Test
//	public void updateMemo() {
//		//save() : insert, update
//		
//		Memo memo = Memo.builder()
//						.mno(80l)
//						.memoText("메모수정")
//						.build();
//		
//		
//		Memo update=memoRepository.save(memo);
//		System.out.println(update);
//	}
	
	@Test
	public void deleteMemo() {
		memoRepository.deleteById(90l);
	}
}















