package be.vdab.personeelfix.services;

import java.util.Optional;

import be.vdab.personeelfix.entities.Employee;
import be.vdab.personeelfix.valueobjects.SocialSecurityNumber;

public interface EmployeeService {

	public Optional<Employee> read(final long employeeId);
	void saveSSN(final long employeeId, final SocialSecurityNumber number);
}
