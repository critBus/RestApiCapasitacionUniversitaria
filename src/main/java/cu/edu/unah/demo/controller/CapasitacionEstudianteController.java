
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
@RequestMapping("/CapasitacionEstudiante")
@RestController
public class CapasitacionEstudianteController {
	@Autowired
	private CapasitacionEstudianteServices capasitacionestudianteservices;
	@GetMapping(path = { "/findAll" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<CapasitacionEstudiante>> findAll() {
		try {
			return new ResponseEntity<List<CapasitacionEstudiante>>(capasitacionestudianteservices.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(path = { "/find/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CapasitacionEstudiante> findById(@PathVariable Integer id) {
		try {
			return new ResponseEntity<CapasitacionEstudiante>(capasitacionestudianteservices.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping(path = { "/create" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CapasitacionEstudiante> createCapasitacionEstudiante(
			@RequestBody CapasitacionEstudiante capasitacionestudiante) throws URISyntaxException {
		CapasitacionEstudiante result = capasitacionestudianteservices.save(capasitacionestudiante);
		return ResponseEntity.created(new URI("/CapasitacionEstudiante/create/" + result.getId())).body(result);
	}
	@PutMapping(path = { "/update" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CapasitacionEstudiante> updateCarrera(@RequestBody CapasitacionEstudiante capasitacionestudiante) throws URISyntaxException {
		if (capasitacionestudiante.getId()==null) {
			return new ResponseEntity<CapasitacionEstudiante>(HttpStatus.NOT_FOUND);
		}
		try {
			CapasitacionEstudiante result = capasitacionestudianteservices.update(capasitacionestudiante);
			return ResponseEntity.created(new URI("/CapasitacionEstudiante/updated/" + result.getId())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		capasitacionestudianteservices.delete(id);
		return ResponseEntity.ok().build();
	}
}
