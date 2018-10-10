package com.alsoftware.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class MemberDaoImpl implements MemberDao {

	private PreparedStatement ps;
	private ResultSet rs;
	private Connection con = DatabaseCon.getInstance().getCon();
	
	public List <Member> findAllMembers() {
		
		try {

			List <Member> members = new ArrayList<>();
			ps = con.prepareStatement("Select * from Members");
			rs = ps.executeQuery();

			while (rs.next()) {

				Member member = new Member();
				member.setMemberNumber(rs.getString("MemberNumber"));
				member.setType(rs.getString("type"));
				member.setFirstName(rs.getString("FirstName"));
				member.setLastName(rs.getString("LastName"));
				member.setStreetAddress(rs.getString("StreetAddress"));
				member.setCity(rs.getString("City"));
				member.setProvince(rs.getString("Province"));
				member.setPostalCode(rs.getString("PostalCode"));
				member.setEmail(rs.getString("Email"));
				member.setPhone(rs.getString("Phone"));
				member.setComment(rs.getString("Comment"));
				members.add(member);

			}

			return members;

		} catch (SQLException ex) {

			ex.printStackTrace();
					
		}

		return null;	
	}
	
	@Override
	public List <Member> findCertMembers(String param) {
	   
		List <Member> members = new ArrayList<>(); 
		String number = param;
		String fname = param; 
		String lname = param; 
		
		try {
			HashMap <String, String> map = new LinkedHashMap<>();

			if (number != null && number.length()!=0) {
				map.put("MemberNumber", number);
			}

		    if (fname != null && fname.length()!=0) {
				map.put("FirstName", fname);
			}
			if (lname != null && lname.length()!=0) {
				map.put("LastName", lname);
			}

			StringBuilder sb = new StringBuilder("Select * from Members ");
			Set<String> set = map.keySet();
			
			if (set.size() >= 1) {

				sb.append("Where ");

			} else {

				return null;
			}
         	
			int count = 0;
			for (var i=0; i<map.size(); i++) {

				sb.append(map.keySet().toArray()[count]);
				sb.append("=?");
				ps = con.prepareStatement(sb.toString());
			    ps.setString(1, (String) map.values().toArray()[count]);	 	
				rs = ps.executeQuery();
				
				while (rs.next()) {
					SuppMethods ex = new SuppMethods();
					members.add(ex.extractMemberFromRs(rs));
				}
				count++; 
				sb.delete(28, 45); 		
			}
	
			if (members.isEmpty()) {
				
				return null; 
			} 
			
			return members; 
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return null;
	}

	public boolean insertMember(Member member) {
        
		boolean updated = false; 
		
		try {
			ps = con.prepareStatement(
					"Insert into Members (MemberNumber, Type, FirstName, LastName, StreetAddress, City, Province, PostalCode, Email, Phone)"
							+ "Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");

			ps.setString(1, member.getMemberNumber());
			ps.setString(2, member.getType());
			ps.setString(3, member.getFirstName());
			ps.setString(4, member.getLastName());
			ps.setString(5, member.getStreetAddress());
			ps.setString(6, member.getCity());
			ps.setString(7, member.getProvince());
			ps.setString(8, member.getPostalCode());
			ps.setString(9, member.getEmail());
			ps.setString(10, member.getPhone());

			SuppMethods ex = new SuppMethods(); 
			
			if (ex.checkID(member.getMemberNumber())) {

				return updated;
				
			}

			else {

				int i = ps.executeUpdate();
				if (i == 1) {
		
				 return updated = true;
				
				}

			}

		} catch (SQLException ex) {

			ex.printStackTrace();

		}
		
		return updated; 
	}
	
	public boolean deleteMember(Member member) {
		
        boolean updated = false;
		
		try {
			ps = con.prepareStatement("Delete from Members where MemberNumber = ?");
			ps.setString(1, member.getMemberNumber());

			int i = ps.executeUpdate();

			if (i == 1) {

               return updated = true; 
               
			} 

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
          return updated; 
		
	}

	public boolean updateMember(Member member) {
		
		boolean updated = false; 

		try {
			ps = con.prepareStatement("Update Members Set MemberNumber=?, Type=?, FirstName=?, LastName=?, "
					+ "StreetAddress=?, City=?, Province=?, PostalCode=?, Email=?, Phone=?, Comment=? Where MemberNumber=?");

			ps.setString(1, member.getMemberNumber());
			ps.setString(2, member.getType());
			ps.setString(3, member.getFirstName());
			ps.setString(4, member.getLastName());
			ps.setString(5, member.getStreetAddress());
			ps.setString(6, member.getCity());
			ps.setString(7, member.getProvince());
			ps.setString(8, member.getPostalCode());
			ps.setString(9, member.getEmail());
			ps.setString(10, member.getPhone());
			ps.setString(11, member.getComment());
			ps.setString(12, member.getMemberNumber());

			int i = ps.executeUpdate();

			if (i == 1) {
				
				return updated = true; 
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return updated; 
		
	}

	@Override
	public List <Member> readMember(List<Member> members) {

		List<Member> list = new ArrayList<>();

		try {
			List<String> membernums = new ArrayList<>();

			members.forEach(m -> membernums.add(m.getMemberNumber()));
			
			StringBuilder sb = new StringBuilder("Select * from Members Where MemberNumber = ?");

			 
			for (String memberNumber : membernums) {
				ps = con.prepareStatement(sb.toString());
				ps.setString(1, memberNumber);;
				rs = ps.executeQuery();
				
			while (rs.next()) {
				    SuppMethods sm = new SuppMethods();
					list.add(sm.extractMemberFromRs(rs));
				}
			}

			return list;

		} catch (SQLException ex) {

			ex.printStackTrace();
		}

		return null;
	}

}
