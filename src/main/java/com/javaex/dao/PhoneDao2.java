package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PhoneVo;

@Repository
public class PhoneDao2 {
	
	@Autowired
	private SqlSession sqlSession;
	

	public PhoneDao2() {
		
	}
	
	// 리스트 가져오기
	public List<PhoneVo> getPersonList() {
		List<PhoneVo> pList= sqlSession.selectList("phonebook.selectList");
		return pList;
	}
	
	
	// 전화번호 등록
	public int personInsert(PhoneVo pv) {
		return sqlSession.insert("phonebook.insert", pv);
	}
	
	/*

	public void personInsert(PhoneVo pv) {
		
		this.getConnection();

		try {
			String query= "";
			query += " insert into person ";
			query += " values(seq_person_id.nextval, ?, ?, ?) ";
		
		    pstmt= conn.prepareStatement(query);
		    
		    pstmt.setString(1, pv.getName()); // name
		    pstmt.setString(2, pv.getHp()); // hp
		    pstmt.setString(3, pv.getCompany()); // company		   

		    int count= pstmt.executeUpdate();	    
		    		   	    
		    System.out.println("["+count+"건 등록되었습니다.]");
		        	    
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} 
		this.close();
	}
	
	
	public void personUpdate(PhoneVo pv) {
		
		this.getConnection();

		try {
			String query= "";
			query += " update 	person ";
			query += " set 		name= ?, ";
			query += " 	   		hp= ?, ";
			query += " 	   		company= ? ";
			query += " where	person_id= ? ";
			
		    pstmt= conn.prepareStatement(query);
		    
		    pstmt.setString(1, pv.getName());
		    pstmt.setString(2, pv.getHp());
		    pstmt.setString(3, pv.getCompany());
		    pstmt.setInt(4, pv.getPersonId());
		    
		    int count= pstmt.executeUpdate();
		    
		    System.out.println("["+count+"건 수정되었습니다.]");
		    
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} 
		this.close();
	}
	
	
	public void personDelete(int personId) {
		
		this.getConnection();

		try {
			String query= "";
			query += " delete from person ";
			query += " where	   person_id= ? ";
			
		    pstmt= conn.prepareStatement(query);
		    
		    pstmt.setInt(1, personId);
		    
		    int count= pstmt.executeUpdate();
		    
		    System.out.println("["+count+"건 삭제되었습니다.]");
		    
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		}
		this.close();
	}
	
	
	public List<PhoneVo> getPersonList() {
		List<PhoneVo> pList= new ArrayList<PhoneVo>();
		
		this.getConnection();
		
		try {
			String query= "";
			query += " select   person_id, "; 
			query += "          name, ";
			query += "          hp, ";
			query += "          company ";
			query += " from     person ";

			pstmt= conn.prepareStatement(query);
			
			rs= pstmt.executeQuery();

            while(rs.next()) {           
            	int personId= rs.getInt("person_id"); 
            	String name= rs.getString("name");
            	String hp= rs.getString("hp");
            	String company= rs.getString("company");
            	
            	PhoneVo vo= new PhoneVo(personId, name, hp, company);
            	pList.add(vo);
            }

		} catch (SQLException e) {
		    System.out.println("error:" + e);
		}	
		this.close();
		
		return pList;
	}
	
	public void printList() {			
		System.out.println("<1.리스트>");
		
		for(PhoneVo pv: this.getPersonList()) {
			pv.showInfo();
		}
	}
	
	
	public List<PhoneVo> personSearch(String search) {
		List<PhoneVo> pList= new ArrayList<PhoneVo>();
		
		this.getConnection();
		
		try {
			String query= "";
			query += " select   person_id, "; 
			query += "          name, ";
			query += "          hp, ";
			query += "          company ";
			query += " from     person ";
			query += " where    (name like ? or hp like ? or company like ?) ";

			pstmt= conn.prepareStatement(query);
			
			pstmt.setString(1, "%"+search+"%");
			pstmt.setString(2, "%"+search+"%");
			pstmt.setString(3, "%"+search+"%");
		    
			rs= pstmt.executeQuery();

            while(rs.next()) {           
            	int personId= rs.getInt("person_id"); 
            	String name= rs.getString("name");
            	String hp= rs.getString("hp");
            	String company= rs.getString("company");
            	
            	PhoneVo vo= new PhoneVo(personId, name, hp, company);
            	pList.add(vo);
            }
            
            for(PhoneVo pv: pList) {
            	pv.showInfo();
            }

		} catch (SQLException e) {
		    System.out.println("error:" + e);
		}	
		this.close();
		
		return pList;
	}
	
	public PhoneVo getPerson(int id) {
		PhoneVo pv= null;
		
		this.getConnection();
		
		try {
			String query= "";
			query += " select   person_id, "; 
			query += "          name, ";
			query += "          hp, ";
			query += "          company ";
			query += " from     person ";
			query += " where    person_id= ? ";

			pstmt= conn.prepareStatement(query);
			
			pstmt.setInt(1, id);
			
			rs= pstmt.executeQuery();
			
			while(rs.next()) {           
            	int personId= rs.getInt("person_id"); 
            	String name= rs.getString("name");
            	String hp= rs.getString("hp");
            	String company= rs.getString("company");
            	
            	pv= new PhoneVo(personId, name, hp, company);
            }

		} catch (SQLException e) {
		    System.out.println("error:" + e);
		}	
		this.close();

		return pv;
	}
	*/
}

