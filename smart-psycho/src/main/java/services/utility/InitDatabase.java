package services.utility;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import services.interfaces.UtilisateurServicesLocal;

@Singleton
@LocalBean
@Startup
public class InitDatabase {

	@EJB
	UtilisateurServicesLocal patientServicesLocal;

	@PostConstruct
	public void init() {

		// patientServicesLocal.add(new Patient("Med Aymen", new Date(),
		// "description", "admin", "password"));
	}

}
