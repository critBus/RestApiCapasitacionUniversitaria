
package cu.edu.unah.demo.controller;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cu.edu.unah.demo.model.*;
import cu.edu.unah.demo.services.*;
@RequestMapping("/CapasitacionProfesor")
@RestController
public class CapasitacionProfesorController {
	@Autowired
	private CapasitacionProfesorServices capasitacionprofesorservices;
	@GetMapping(path = { "/findAll" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<CapasitacionProfesor>> findAll() {
		try {
			return new ResponseEntity<List<CapasitacionProfesor>>(capasitacionprofesorservices.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(path = { "/find/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CapasitacionProfesor> findById(@PathVariable Integer id) {
		try {
			return new ResponseEntity<CapasitacionProfesor>(capasitacionprofesorservices.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping(path = { "/create" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CapasitacionProfesor> createCapasitacionProfesor(
			@RequestBody CapasitacionProfesor capasitacionprofesor) throws URISyntaxException {
		CapasitacionProfesor result = capasitacionprofesorservices.save(capasitacionprofesor);
		return ResponseEntity.created(new URI("/CapasitacionProfesor/create/" + result.getId())).body(result);
	}
	@PutMapping(path = { "/update" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CapasitacionProfesor> update(@RequestBody CapasitacionProfesor capasitacionprofesor) throws URISyntaxException {
		if (capasitacionprofesor.getId()==null) {
			return new ResponseEntity<CapasitacionProfesor>(HttpStatus.NOT_FOUND);
		}
		try {
			CapasitacionProfesor result = capasitacionprofesorservices.update(capasitacionprofesor);
			return ResponseEntity.created(new URI("/CapasitacionProfesor/updated/" + result.getId())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		capasitacionprofesorservices.delete(id);
		return ResponseEntity.ok().build();
	}
}
