
package cu.edu.unah.demo.services;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import cu.edu.unah.demo.model.*;
import cu.edu.unah.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CapasitacionProfesorServices {
	@Autowired
	private CapasitacionProfesorRepository capasitacionprofesorrepository;
	public List<CapasitacionProfesor> findAll() {
		return capasitacionprofesorrepository.findAll();
	}
	public CapasitacionProfesor findById(Integer id) {
		return capasitacionprofesorrepository.findById(id).get();
	}
	public CapasitacionProfesor save(CapasitacionProfesor capasitacionprofesor) {
		if (capasitacionprofesor.getId()!=null && capasitacionprofesorrepository.existsById(capasitacionprofesor.getId())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		return capasitacionprofesorrepository.save(capasitacionprofesor);
	}
	public CapasitacionProfesor update(CapasitacionProfesor capasitacionprofesor) {
		if (capasitacionprofesor.getId()!=null && !capasitacionprofesorrepository.existsById(capasitacionprofesor.getId())) {
			throw new EntityExistsException("There is no entity with such ID in the database.");
		}
		return capasitacionprofesorrepository.save(capasitacionprofesor);
	}
	public void delete(Integer id) {
		capasitacionprofesorrepository.deleteById(id);
	}
}
