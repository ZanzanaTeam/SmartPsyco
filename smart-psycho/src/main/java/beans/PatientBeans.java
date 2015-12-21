package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import services.interfaces.PatientServicesLocal;
import domaine.Patient;

@ManagedBean
public class PatientBeans {

	
	private Patient patient;

	@EJB PatientServicesLocal patientServicesLocal;
	
	public String inscription(){
		
		if(patientServicesLocal.add(patient)){
			return "login";
		}
		return "";
	}
	
	public String authentificatin(){
		if(patientServicesLocal.findPatientByLoginPassword(patient.getLogin(), patient.getPassword())){
			return "principalePatient";
		}
		return "";
	}
		
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
}
