package services.interfaces;

import javax.ejb.Local;

import domaine.Experience;
import services.interfaces.basic.ICrud;

@Local
public interface ExperienceServicesLocal extends ICrud<Experience> {

	void updateVisible(Integer id);	
}
