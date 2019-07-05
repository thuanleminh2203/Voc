package thuanlm.com.Demo.sercive;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thuanlm.com.Demo.entity.Employee;
import thuanlm.com.Demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAll(){
		return employeeRepository.findAll();
	}
	
	public Employee create(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Optional<Employee> findByID(int id){
		return employeeRepository.findById(id);
	}
	
	public void delete(Employee employee) {
		 employeeRepository.delete(employee);
	}
	
	public int deleteByCompany(Integer id) {
		return employeeRepository.deleteByCompany(id);
		
	}

}
