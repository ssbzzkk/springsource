package com.spring.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) //테스트코드가 스프링프레임워크 안에서 실행
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",

		"file:src/main/webapp/WEB-INF/spring/security-context.xml" })
public class MemberTest {

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private DataSource ds;

	@Test // 테스트 메소드(파라메터 없음, 리턴타입 없음) 임을 알려줌 
	public void test() {
		String sql = "insert into spring_member(userid, userpw,username) values(?,?,?)";

		for (int i = 0; i < 50; i++) {
			try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
				pstmt.setString(2, encoder.encode("pw" + i)); // pw0~pw49
				// 50명 회원 => 일반회원20, 매니저 20, 관리자 10명

				if (i < 20) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "일반회원" + i);
				} else if (i < 40) {
					pstmt.setString(1, "manager" + i);
					pstmt.setString(3, "매니저" + i);
				} else {
					pstmt.setString(1, "admin" + i);
					pstmt.setString(3, "관리자" + i);
				}
				
				pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
