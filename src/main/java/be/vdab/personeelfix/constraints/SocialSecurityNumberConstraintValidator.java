package be.vdab.personeelfix.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import be.vdab.personeelfix.valueobjects.SocialSecurityNumber;

public class SocialSecurityNumberConstraintValidator implements
ConstraintValidator<SocialSecurityNumberConstraint, SocialSecurityNumber>{
	
	@Override
	public void initialize(final SocialSecurityNumberConstraint number) {}
	
	@Override
	public boolean isValid(
			final SocialSecurityNumber socialSecurityNumber,
			final ConstraintValidatorContext context) {
		if (socialSecurityNumber == null) return true;
		
		return socialSecurityNumber.validateFormat();
	}

}
