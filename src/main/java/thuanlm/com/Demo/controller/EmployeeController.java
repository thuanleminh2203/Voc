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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thuanlm.com.Demo.entity.Company;
import thuanlm.com.Demo.entity.Employee;
import thuanlm.com.Demo.exception.ResourceNotFoundException;
import thuanlm.com.Demo.sercive.CompanyService;
import thuanlm.com.Demo.sercive.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private CompanyService companyService;
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAll() {
		return new ResponseEntity<List<Employee>>(employeeService.getAll(), HttpStatus.OK);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Employee> create(@RequestBody Employee employee, @PathVariable int id){
		Optional<Company> optional = companyService.findByID(id);
		if(!optional.isPresent()) {
			throw new ResourceNotFoundException("Not found company with id :" + id);
		}
		Company company = optional.get();
		employee.setCompany(company);
		return new ResponseEntity<Employee>(employeeService.create(employee),HttpStatus.CREATED);
	}
	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<HttpStatus> delete(@PathVariable int id){
//		Optional<Employee> optional = employeeService.findByID(id);
//		if(!optional.isPresent()) {
//			throw new ResourceNotFoundException("Not found employee");
//		}
//		employeeService.delete(optional.get());
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleEntity(@PathVariable int id){
		employeeService.deleteByCompany(id);
		
		return new ResponseEntity<HttpStatus>( HttpStatus.OK);
	}

}
