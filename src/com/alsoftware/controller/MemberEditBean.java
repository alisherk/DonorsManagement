package com.alsoftware.controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.alsoftware.model.Member;
import com.alsoftware.model.MemberDao;
import com.alsoftware.model.MemberDaoImpl;

@ManagedBean 
@SessionScoped 

public class MemberEditBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Member member = new Member();
	private String previousPageId; 

	public MemberEditBean() {
		
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	} 
	
	public String getPreviousPageId() {
		return previousPageId;
	}

	public void setPreviousPageId(String previousPageId) {
		this.previousPageId = previousPageId;
	}
	
	public String updateMember(Member member) {

		MemberDao da = new MemberDaoImpl();
		String id = this.getPreviousPageId();
		if (da.updateMember(member) == true) {

			if (id.equals("/data.xhtml")) {

				return "data?faces-redirect=true";

			}
			if (id.equals("/filter.xhtml")) {

				return "filter?faces-redirect=true";
			}

		}
		return null;
	}
    
	public String cancelRequest() {
		
    String id = this.getPreviousPageId(); 
   
      if(id.equals("/data.xhtml")) {
    	
    	return "data?faces-redirect=true"; 	
    	
    } else if(id.equals("/filter.xhtml")) {
    	
    	return "filter?faces-redirect=true"; 
    	
    } 
       return null; 			
	}

}
