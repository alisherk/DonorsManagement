package com.alsoftware.model;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Member member = new Member("3", "Annual", "Ali", "Seg"); 
        
        MemberDao dao = new MemberDaoImpl(); 
        dao.insertMember(member); 
        
        List <Member> members = dao.findCertMembers("3"); 
        
        System.out.println(members.get(0).getMemberNumber()); 
        
        
	}

}
