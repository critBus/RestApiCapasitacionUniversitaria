
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
@RequestMapping("/Capasitacion")
@RestController
public class CapasitacionController {
	@Autowired
	private CapasitacionServices capasitacionservices;
	@GetMapping(path = { "/findAll" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Capasitacion>> findAll() {
		try {
			return new ResponseEntity<List<Capasitacion>>(capasitacionservices.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(path = { "/find/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Capasitacion> findById(@PathVariable Integer id) {
		try {
			return new ResponseEntity<Capasitacion>(capasitacionservices.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping(path = { "/create" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Capasitacion> createCapasitacion(
			@RequestBody Capasitacion capasitacion) throws URISyntaxException {
		Capasitacion result = capasitacionservices.save(capasitacion);
		return ResponseEntity.created(new URI("/Capasitacion/create/" + result.getId())).body(result);
	}
	@PutMapping(path = { "/update" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Capasitacion> update(@RequestBody Capasitacion capasitacion) throws URISyntaxException {
		if (capasitacion.getId()==null) {
			return new ResponseEntity<Capasitacion>(HttpStatus.NOT_FOUND);
		}
		try {
			Capasitacion result = capasitacionservices.update(capasitacion);
			return ResponseEntity.created(new URI("/Capasitacion/updated/" + result.getId())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		capasitacionservices.delete(id);
		return ResponseEntity.ok().build();
	}
}
