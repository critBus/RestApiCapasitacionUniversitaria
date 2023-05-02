
package cu.edu.unah.demo.services;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import cu.edu.unah.demo.model.*;
import cu.edu.unah.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ProfesorServices {
	@Autowired
	private ProfesorRepository profesorrepository;
	public List<Profesor> findAll() {
		return profesorrepository.findAll();
	}
	public Profesor findById(Integer id) {
		return profesorrepository.findById(id).get();
	}
	public Profesor save(Profesor profesor) {
		if (profesor.getId()!=null && profesorrepository.existsById(profesor.getId())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		return profesorrepository.save(profesor);
	}
	public Profesor update(Profesor profesor) {
		if (profesor.getId()!=null && !profesorrepository.existsById(profesor.getId())) {
			throw new EntityExistsException("There is no entity with such ID in the database.");
		}
		return profesorrepository.save(profesor);
	}
	public void delete(Integer id) {
		profesorrepository.deleteById(id);
	}
}
