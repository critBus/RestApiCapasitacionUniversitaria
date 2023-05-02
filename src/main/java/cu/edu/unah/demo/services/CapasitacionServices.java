
package cu.edu.unah.demo.services;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import cu.edu.unah.demo.model.*;
import cu.edu.unah.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CapasitacionServices {
	@Autowired
	private CapasitacionRepository capasitacionrepository;
	public List<Capasitacion> findAll() {
		return capasitacionrepository.findAll();
	}
	public Capasitacion findById(Integer id) {
		return capasitacionrepository.findById(id).get();
	}
	public Capasitacion save(Capasitacion capasitacion) {
		if (capasitacion.getId()!=null && capasitacionrepository.existsById(capasitacion.getId())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		return capasitacionrepository.save(capasitacion);
	}
	public Capasitacion update(Capasitacion capasitacion) {
		if (capasitacion.getId()!=null && !capasitacionrepository.existsById(capasitacion.getId())) {
			throw new EntityExistsException("There is no entity with such ID in the database.");
		}
		return capasitacionrepository.save(capasitacion);
	}
	public void delete(Integer id) {
		capasitacionrepository.deleteById(id);
	}
}
