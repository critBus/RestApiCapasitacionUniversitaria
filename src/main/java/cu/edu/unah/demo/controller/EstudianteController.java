
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
@RequestMapping("/Estudiante")
@RestController
public class EstudianteController {
	@Autowired
	private EstudianteServices estudianteservices;
	@GetMapping(path = { "/findAll" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Estudiante>> findAll() {
		try {
			return new ResponseEntity<List<Estudiante>>(estudianteservices.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(path = { "/find/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Estudiante> findById(@PathVariable Integer id) {
		try {
			return new ResponseEntity<Estudiante>(estudianteservices.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping(path = { "/create" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Estudiante> createEstudiante(
			@RequestBody Estudiante estudiante) throws URISyntaxException {
		Estudiante result = estudianteservices.save(estudiante);
		return ResponseEntity.created(new URI("/Estudiante/create/" + result.getId())).body(result);
	}
	@PutMapping(path = { "/update" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Estudiante> update(@RequestBody Estudiante estudiante) throws URISyntaxException {
		if (estudiante.getId()==null) {
			return new ResponseEntity<Estudiante>(HttpStatus.NOT_FOUND);
		}
		try {
			Estudiante result = estudianteservices.update(estudiante);
			return ResponseEntity.created(new URI("/Estudiante/updated/" + result.getId())).body(result);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping(path = { "/delete/{id}" }, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		estudianteservices.delete(id);
		return ResponseEntity.ok().build();
	}
}
