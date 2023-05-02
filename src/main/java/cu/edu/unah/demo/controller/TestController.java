package cu.edu.unah.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/inicio")
	public String inicio() {
		return "TEST";
	}
	
}
