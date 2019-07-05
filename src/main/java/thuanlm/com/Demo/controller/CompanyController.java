package thuanlm.com.Demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thuanlm.com.Demo.entity.Company;
import thuanlm.com.Demo.exception.ResourceNotFoundException;
import thuanlm.com.Demo.sercive.CompanyService;
import thuanlm.com.Demo.sercive.EmployeeService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getall")
	public ResponseEntity<List<Company>> getAll() {
		return new ResponseEntity<List<Company>>(companyService.getAll(), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Company> create(@RequestBody Company company) {

		return new ResponseEntity<Company>(companyService.create(company), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Company> update(@RequestBody Company company, @PathVariable int id) {
		Optional<Company> optional = companyService.findByID(id);
		if (!optional.isPresent()) {
			throw new ResourceNotFoundException("Not found");
		}
		Company company2 = optional.get();
		company2.setName(company.getName());
		return new ResponseEntity<Company>(companyService.create(company2), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete( @PathVariable Integer id) {

		Optional<Company> optionalCompany = companyService.findByID(id);
		
		if (!optionalCompany.isPresent()) {
			throw new ResourceNotFoundException("Not found Company with ID : " + id);
		}
		
		
		if (employeeService.deleteByCompany(id) >= 0) {
			companyService.delete(optionalCompany.get());
			return new ResponseEntity<HttpStatus>( HttpStatus.OK);
		}
		
		
		return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);

	}

}
