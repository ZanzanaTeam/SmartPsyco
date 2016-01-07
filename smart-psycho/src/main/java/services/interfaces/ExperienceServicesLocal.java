package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domaine.Experience;
import services.interfaces.basic.ICrud;

@Local
public interface ExperienceServicesLocal extends ICrud<Experience> {

	void updateVisible(Integer id);
	List<Experience> findByPatient(Integer idPatient);
	List<Experience> findByType(String type, Integer idPatient);
}
