package com.alsoftware.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import com.alsoftware.model.DaoFactory;
import com.alsoftware.model.Member;
import com.alsoftware.model.MemberDao;
import com.alsoftware.model.MemberDaoImpl;

@ManagedBean(name = "dao", eager=true)
@ViewScoped 

public class MemberDaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Member> members;
	@ManagedProperty(value = "#{memberEditBean}") 
	private MemberEditBean memberEditBean; 
	@ManagedProperty(value = "#{memberFilterBean}") 
	private MemberFilterBean memberFilterBean;
	
	public MemberDaoBean() {

	    members = new ArrayList<>();
		MemberDao da = new MemberDaoImpl();  
		members.addAll(da.findAllMembers());
	}

	public MemberEditBean getMemberEditBean() {
		return memberEditBean;
	}

	public void setMemberEditBean(MemberEditBean memberEditBean) {
		this.memberEditBean = memberEditBean;
	}
    
	public MemberFilterBean getMemberFilterBean() {
		return memberFilterBean;
	}

	public void setMemberFilterBean(MemberFilterBean memberFilterBean) {
		this.memberFilterBean = memberFilterBean;
	}
   
	public void setMembers(List <Member> members) {
		this.members = members;
	}

    public List<Member> getMembers() {

		return members;

	}

	public String findMembers() {
           
		Map<String, String> values = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		String param = values.get("members-form:searchInputParam"); 
		MemberDao da = DaoFactory.getMemberImplDao(); 
		List <Member> list = new ArrayList<>(); 
		list = da.findCertMembers(param); 
		
		if (list == null) {
			
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "No members exist with such search criteria", null));			
		} else {
			
			this.memberFilterBean.setMembers(list);
			return "filter?faces-redirect=true"; 		
	    }
		
		return null; 	
	} 
	
	public String addMember() {

		Map<String, String> formvalues = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap(); 
		Member member = new Member(); 
		member.setMemberNumber(formvalues.get("add-form:memNum").trim());
		member.setType(formvalues.get("add-form:type").trim());
		member.setFirstName(formvalues.get("add-form:firstName").trim());
		member.setLastName(formvalues.get("add-form:lastName").trim()); 
		member.setStreetAddress(formvalues.get("add-form:address").trim());
		member.setCity(formvalues.get("add-form:city").trim());
		member.setProvince(formvalues.get("add-form:prov").trim());
		member.setPostalCode(formvalues.get("add-form:postalCode").trim());
		member.setEmail(formvalues.get("add-form:email").trim());
		member.setPhone(formvalues.get("add-form:phone").trim());
		
		MemberDao da = DaoFactory.getMemberImplDao(); 
		if(da.insertMember(member) == true) {
			
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Member has been added", null));
			
			return "registration.xhtml?faces-redirect=true";
			
		} else 
			
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_WARN, "This ID is taken. Please choose a different ID", null));
			
		return null; 		
	}

	public String deleteMember(Member member) {

		MemberDao da = DaoFactory.getMemberImplDao();  
		if(da.deleteMember(member)== true) {
			
			
			return "data?faces-redirect=true"; 
			
		} else {
			
			return null; 
			
		}

	}

    public String editMember(Member member) {

    	    String pageId = FacesContext.getCurrentInstance().getViewRoot().getViewId(); 
    	    memberEditBean.setPreviousPageId(pageId);
    	    memberEditBean.setMember(member);	
			return "editing?faces-redirect=true";

		}

}