package com.alsoftware.model;

import java.util.List;

public interface MemberDao {

	public List<Member> findAllMembers(); 
	
	public List<Member> findCertMembers(String param); 
	
	public boolean insertMember(Member member); 
	
	public boolean deleteMember(Member member);
	
	public boolean updateMember(Member member); 
	
	public List<Member> readMember(List<Member> members); 
}
