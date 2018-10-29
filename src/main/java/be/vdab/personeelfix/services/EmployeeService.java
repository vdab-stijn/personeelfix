package be.vdab.personeelfix.services;

import java.util.List;
import java.util.Optional;

import be.vdab.personeelfix.entities.Employee;
import be.vdab.personeelfix.valueobjects.SocialSecurityNumber;

public interface EmployeeService {

	public Optional<Employee> read(final long employeeId);
	public List<Employee> findAll();
	void saveSSN(final long employeeId, final SocialSecurityNumber number);
}
