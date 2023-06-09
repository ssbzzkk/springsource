package com.spring.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.domain.BoardDTO;

@Repository
public class BoardDAO {
		
		private Connection con;
		private PreparedStatement pstmt;
		private ResultSet rs;
		@Autowired
		private DataSource ds;
		
		
		public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
			try {
				rs.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void close(Connection con, PreparedStatement pstmt) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void commit(Connection con) {
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public void rollback(Connection con) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//insert
		public boolean insert(BoardDTO dto) {
				boolean flag=false;
				
				try {
					con=ds.getConnection();
					String sql = "insert into spring_board(bno, title, content, writer ) ";
					sql += "values(seq_board.nextval,?,?,?)";

					pstmt=con.prepareStatement(sql);
					pstmt.setString(1,dto.getTitle());
					pstmt.setString(2,dto.getContent());
					pstmt.setString(3,dto.getWriter());
					
					int result = pstmt.executeUpdate();
					if (result>0) {
						flag=true;
						commit(con);
					}
				} catch (Exception e) {
					rollback(con);
					e.printStackTrace();
				} finally {
					close(con, pstmt);
				}
				return flag;
			}
		
		//전체 리스트 getList()
		public List<BoardDTO> getList(){
			List<BoardDTO> list = new ArrayList<BoardDTO>();

				try {
					con = ds.getConnection();
					String sql = "select * from spring_board";
					pstmt = con.prepareStatement(sql);
					rs=pstmt.executeQuery();
					
					while (rs.next()) {	
						BoardDTO dto = new BoardDTO();
						dto.setBno(rs.getInt("bno"));
						dto.setTitle(rs.getString("title"));
						dto.setContent(rs.getString("content"));
						dto.setWriter(rs.getString("writer"));
						dto.setRegdate(rs.getDate("regdate"));
						dto.setUpdatedate(rs.getDate("updatedate"));
						list.add(dto);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
				 close(con, pstmt, rs);	
				}
				return list;
			}
		
		//삭제
		public boolean delete(int bno) {
			boolean flag = false;
			try {
				con=ds.getConnection();
				String sql="delete from spring_board where bno=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setInt(1, bno);
				
				int result = pstmt.executeUpdate();
				if(result>0) {
					flag=true;
					commit(con);
				}
			} catch (Exception e) {
				rollback(con);
				e.printStackTrace();
			}finally {
				close(con, pstmt);
			}
			return flag;
		}
		
		//수정(bno일치시 title, content, updatedate)
		public boolean update(BoardDTO dto) {
			boolean flag = false;
			try {
				con=ds.getConnection();
				String sql="update spring_board set title=?, content=?, updatedate=sysdate where bno=?";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, dto.getTitle());
				pstmt.setString(2, dto.getContent());
				pstmt.setInt(3, dto.getBno());
				int result = pstmt.executeUpdate();
				if(result>0) {
					flag=true;
					commit(con);
				}
			} catch (Exception e) {
				rollback(con);
				e.printStackTrace();
			}finally {
				close(con, pstmt);
			}
			return flag;
		}
		
		//특정게시물 조회
		public BoardDTO getRow(int bno) {
			BoardDTO dto = null;
			
			try {
				con = ds.getConnection();
				String sql = "select * from spring_board where bno=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bno);
				rs=pstmt.executeQuery();
				
				if (rs.next()) {
					dto = new BoardDTO();
					dto.setBno(rs.getInt("bno"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
					dto.setWriter(rs.getString("writer"));
					dto.setRegdate(rs.getDate("regdate"));
					dto.setUpdatedate(rs.getDate("updatedate"));	 
				}			
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstmt, rs);
			}
			return dto;
		}
}
