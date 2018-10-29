package be.vdab.personeelfix.converters;

import java.math.BigDecimal;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import be.vdab.personeelfix.valueobjects.SocialSecurityNumber;

@Converter(autoApply = true)
public class SocialSecurityNumberConverter
implements AttributeConverter<SocialSecurityNumber, BigDecimal> {

	public SocialSecurityNumberConverter() {}

	@Override
	public BigDecimal convertToDatabaseColumn(
			final SocialSecurityNumber socialSecurityNumber) {
		return socialSecurityNumber.toBigDecimal();
	}

	@Override
	public SocialSecurityNumber convertToEntityAttribute(
			final BigDecimal dbData) {
		return new SocialSecurityNumber(dbData);
	}
}
