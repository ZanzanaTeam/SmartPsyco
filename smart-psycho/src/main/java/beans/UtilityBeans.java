package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class UtilityBeans {

	private String email;
	private String telephone;
	
	
	public String ContacterByMail(String email){
		this.email = email;
		return "envoi_email";
	}
	
	public String sendMail(){
		
		return "psy_liste?faces-redirect=true";
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
	
}
