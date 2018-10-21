package com.alsoftware.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.alsoftware.model.DaoFactory;
import com.alsoftware.model.Member;
import com.alsoftware.model.MemberDao;
import com.alsoftware.model.MemberDaoImpl;

@ManagedBean 
@SessionScoped 

public class MemberFilterBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Member> members;
	@ManagedProperty(value = "#{memberEditBean}") 
	private MemberEditBean memberEditBean; 

	public MemberFilterBean() {
		
		members = new ArrayList<>(); 
			
	}
     
	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public MemberEditBean getMemberEditBean() {
		return memberEditBean;
	}

	public void setMemberEditBean(MemberEditBean memberEditBean) {
		this.memberEditBean = memberEditBean;
	}
	
	public String editMember(Member member) {

		String pageId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		memberEditBean.setPreviousPageId(pageId);
		memberEditBean.setMember(member);
		return "editing?faces-redirect=true";
}

	public String deleteMember(Member member) {

		MemberDao da = DaoFactory.getMemberImplDao(); 
		if(da.deleteMember(member)==true) {
		
			MemberDao dao = new MemberDaoImpl();
		    this.setMembers(dao.readMembers(members));
			return "filteredmembers?faces-redirect=true"; 
			
		} else {
			
			return null; 			
		}

	}

}
