package be.vdab.personeelfix.web.forms;

import javax.validation.constraints.NotNull;

import be.vdab.personeelfix.constraints.SocialSecurityNumberConstraint;
import be.vdab.personeelfix.constraints.SocialSecurityNumberFormConstraint;
import be.vdab.personeelfix.entities.Employee;
import be.vdab.personeelfix.valueobjects.SocialSecurityNumber;

@SocialSecurityNumberFormConstraint
public class SocialSecurityNumberForm {

	@NotNull
	private Employee employee;
	
	@SocialSecurityNumberConstraint
	private SocialSecurityNumber socialSecurityNumber;
	
	public SocialSecurityNumberForm() {}
	public SocialSecurityNumberForm(
			final Employee employee,
			final SocialSecurityNumber socialSecurityNumber) {
		setEmployee(employee);
		setSocialSecurityNumber(socialSecurityNumber);
	}
	
	public void setEmployee(final Employee employee) {
		this.employee = employee;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setSocialSecurityNumber(
			final SocialSecurityNumber socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	
	public SocialSecurityNumber getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
}
