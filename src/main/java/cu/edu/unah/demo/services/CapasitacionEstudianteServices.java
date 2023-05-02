
package cu.edu.unah.demo.services;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import cu.edu.unah.demo.model.*;
import cu.edu.unah.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CapasitacionEstudianteServices {
	@Autowired
	private CapasitacionEstudianteRepository capasitacionestudianterepository;
	public List<CapasitacionEstudiante> findAll() {
		return capasitacionestudianterepository.findAll();
	}
	public CapasitacionEstudiante findById(Integer id) {
		return capasitacionestudianterepository.findById(id).get();
	}
	public CapasitacionEstudiante save(CapasitacionEstudiante capasitacionestudiante) {
		if (capasitacionestudiante.getId()!=null && capasitacionestudianterepository.existsById(capasitacionestudiante.getId())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		return capasitacionestudianterepository.save(capasitacionestudiante);
	}
	public CapasitacionEstudiante update(CapasitacionEstudiante capasitacionestudiante) {
		if (capasitacionestudiante.getId()!=null && !capasitacionestudianterepository.existsById(capasitacionestudiante.getId())) {
			throw new EntityExistsException("There is no entity with such ID in the database.");
		}
		return capasitacionestudianterepository.save(capasitacionestudiante);
	}
	public void delete(Integer id) {
		capasitacionestudianterepository.deleteById(id);
	}
}
