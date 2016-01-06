package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import domaine.Utilisateur;
import utility.SendMail;

@ManagedBean
public class UtilityBeans {

	private String email;
	private String telephone;
	private String body;
	private String sujet;
	
	public String ContacterByMail(String email){
		this.email = email;
		return "envoi_email";
	}
	
	public String ContacterBySms(String telephone){
		this.telephone = telephone;
		return "";
	}
	
	public String sendMail(){
		
		Utilisateur utilisateur = (Utilisateur) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		SendMail.sendMail(email, "le patient "+utilisateur.getFullName()+" \n \n"+body, " Contacter SmartPsycho < "+sujet+" >");
		
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

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	
}
