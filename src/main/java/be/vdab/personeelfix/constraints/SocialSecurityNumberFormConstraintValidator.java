package be.vdab.personeelfix.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import be.vdab.personeelfix.web.forms.SocialSecurityNumberForm;

public class SocialSecurityNumberFormConstraintValidator implements
ConstraintValidator<
	SocialSecurityNumberFormConstraint, SocialSecurityNumberForm> {

	@Override
	public final void initialize(
			final SocialSecurityNumberFormConstraint arg0) {}
	
	@Override
	public boolean isValid(
			final SocialSecurityNumberForm form,
			final ConstraintValidatorContext context) {
		if (form.getEmployee() == null ||
				form.getSocialSecurityNumber() == null)
			return true;
		
		return form.getSocialSecurityNumber().validate(form.getEmployee());
	}

}
