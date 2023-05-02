
package cu.edu.unah.demo.services;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import cu.edu.unah.demo.model.*;
import cu.edu.unah.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EstudianteServices {
	@Autowired
	private EstudianteRepository estudianterepository;
	public List<Estudiante> findAll() {
		return estudianterepository.findAll();
	}
	public Estudiante findById(Integer id) {
		return estudianterepository.findById(id).get();
	}
	public Estudiante save(Estudiante estudiante) {
		if (estudiante.getId()!=null && estudianterepository.existsById(estudiante.getId())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		return estudianterepository.save(estudiante);
	}
	public Estudiante update(Estudiante estudiante) {
		if (estudiante.getId()!=null && !estudianterepository.existsById(estudiante.getId())) {
			throw new EntityExistsException("There is no entity with such ID in the database.");
		}
		return estudianterepository.save(estudiante);
	}
	public void delete(Integer id) {
		estudianterepository.deleteById(id);
	}
}
