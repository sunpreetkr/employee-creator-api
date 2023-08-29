package io.nology.EmployeeCreator.employee;
	
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nology.EmployeeCreator.exceptions.NotFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<?> createEmployee(@Valid @RequestBody CreateEmployeeDTO data) {
		Employee createdEmployee = this.employeeService.create(data);
		return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> allEmployees = this.employeeService.findAll();
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getById(@PathVariable Long id) {
		Optional<Employee> foundEmployee = this.employeeService.findById(id);
		
		if(foundEmployee.isEmpty()) {
			throw new NotFoundException(String.format("Employee with id: %s not found", id));
		}
		return new ResponseEntity<>(foundEmployee.get(), HttpStatus.OK);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Employee> updateById(@PathVariable Long id, @Valid @RequestBody UpdateEmployeeDTO data) {
		Optional<Employee> maybeUpdated = this.employeeService.updateById(id, data);

		if(maybeUpdated.isEmpty()) {
			throw new NotFoundException(String.format("Employee with id: %s not found, could not update", id));
		}
		return new ResponseEntity<Employee>(maybeUpdated.get(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee> deleteById(@PathVariable Long id) {
		boolean deleted = this.employeeService.deleteById(id);
		if(!deleted) {
			throw new NotFoundException(String.format("Employee with id: %s not found, could not delete", id));
		}
		return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
	}

}