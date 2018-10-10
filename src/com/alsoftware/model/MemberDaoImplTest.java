package com.alsoftware.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
	void testFindCertMembers() {
		
		MemberDao dao = new MemberDaoImpl();
		assertNotNull(dao.findCertMembers("1")); 
		assertNotNull(dao.findCertMembers("Alisher"));
		assertNotNull(dao.findCertMembers("Kabil"));
		assertNull(dao.findCertMembers(null));
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
		member.setCity("wpg");
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
		Connection con = DatabaseCon.getInstance().getCon();

		try {
			List<String> memnums = new ArrayList<>();
			List<Member> members = Arrays.asList(

					new Member("1", "weekly", "Bob", "Dylan"), new Member("2", "yearly", "Mike", "Fisher")

			);

			members.forEach(m -> memnums.add(m.getMemberNumber()));

			StringBuilder sb = new StringBuilder("Select * from Members Where MemberNumber = ?");

			for (String number : memnums) {
				PreparedStatement ps = con.prepareStatement(sb.toString());
				ps.setString(1, number);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					SuppMethods sm = new SuppMethods();
					list.add(sm.extractMemberFromRs(rs));
				}
				
				assertNotNull(list);

			}

		} catch (SQLException ex) {

			ex.printStackTrace();
		}
	}

}
