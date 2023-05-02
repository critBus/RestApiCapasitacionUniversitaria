
package cu.edu.unah.demo.services;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import cu.edu.unah.demo.model.*;
import cu.edu.unah.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UniversitarioServices {
	@Autowired
	private UniversitarioRepository universitariorepository;
	public List<Universitario> findAll() {
		return universitariorepository.findAll();
	}
	public Universitario findById(Integer id) {
		return universitariorepository.findById(id).get();
	}
	public Universitario save(Universitario universitario) {
		if (universitario.getId()!=null && universitariorepository.existsById(universitario.getId())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		return universitariorepository.save(universitario);
	}
	public Universitario update(Universitario universitario) {
		if (universitario.getId()!=null && !universitariorepository.existsById(universitario.getId())) {
			throw new EntityExistsException("There is no entity with such ID in the database.");
		}
		return universitariorepository.save(universitario);
	}
	public void delete(Integer id) {
		universitariorepository.deleteById(id);
	}
}
