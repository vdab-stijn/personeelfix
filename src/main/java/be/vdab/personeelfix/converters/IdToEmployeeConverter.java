package be.vdab.personeelfix.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import be.vdab.personeelfix.entities.Employee;
import be.vdab.personeelfix.services.EmployeeService;

public class IdToEmployeeConverter implements Converter<Long, Employee>{

	@Autowired
	private final EmployeeService employeeService;
	
	public IdToEmployeeConverter(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@Override
	public Employee convert(Long source) {
		return employeeService.read(source).get();
	}
}
