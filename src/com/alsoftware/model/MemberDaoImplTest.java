package com.alsoftware.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;

class MemberDaoImplTest {
	
	@Test
	void testFindAllMembers() {
	
		MemberDao dao = new MemberDaoImpl(); 
		List <Member> members = dao.findAllMembers(); 
		assertNotNull(members);
	}
	
	@Test
	void testInsertUpdateAndDelete() {
        
		try {
		
		//insert 
		Member member = new Member("100", "Annual", "Allison", "Kabil");
	    MemberDao dao = new MemberDaoImpl();
		dao.insertMember(member); 
		List<Member> members = dao.findCertMembers("100"); 
		assertEquals(members.get(0).getMemberNumber(), member.getMemberNumber());
		
		//update 
		member.setFirstName("Tom");
		assertTrue(dao.updateMember(member));
		
		//delete 
		assertTrue(dao.deleteMember(member));
		
	} catch (Exception ex) {
		
		ex.printStackTrace();
	 }
		
	}

}
