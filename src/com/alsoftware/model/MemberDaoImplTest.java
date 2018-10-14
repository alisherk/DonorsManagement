package com.alsoftware.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class MemberDaoImplTest {
	
	@Test
	void testFindAllMembers() {
		
		List <Member> members; 
		MemberDao dao = new MemberDaoImpl(); 
		members = dao.findAllMembers(); 
		assertNotNull(members);
	}
	
	@Test
	void testInsertMember() {
		Member member = new Member("number", "type", "firstName", "lastName", "address", "city", "prov", "postal", 
				"phone", "email", "comment"); 
		MemberDao dao = new MemberDaoImpl(); 
		assertTrue(dao.insertMember(member));
	}
     
	@Test
	void testUpdateMember() throws SQLException {
		
		Connection con = DatabaseCon.getInstance().getCon(); 
		PreparedStatement ps = con.prepareStatement("Select * from Members Where MemberNumber = 'number'"); 
		ResultSet rs = ps.executeQuery(); 
		SuppMethods ex = new SuppMethods(); 
		Member member = new Member(); 
		
		while(rs.next()) {
			
			ex.extractMemberFromRs(rs); 
					
		}
		member.setCity("Wpg");
		MemberDao dao = new MemberDaoImpl(); 
		assertTrue(dao.updateMember(member));
	}
	
    @Test
	void testDeleteMember() {
		MemberDao dao = new MemberDaoImpl(); 
		Member member = new Member(); 
		member.setMemberNumber("number");
		assertTrue(dao.deleteMember(member));
	}

	@Test 
	void readMember() {

        List<Member> list = new ArrayList<>();
        MemberDao dao = new MemberDaoImpl(); 
        dao.readMembers(list); 
        assertNotNull(list);
		

	}

}
