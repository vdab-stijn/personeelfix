package be.vdab.personeelfix.converters;

import org.springframework.core.convert.converter.Converter;

import be.vdab.personeelfix.valueobjects.SocialSecurityNumber;

public class StringToSocialSecurityNumberConverter
implements Converter<String, SocialSecurityNumber>{

	@Override
	public SocialSecurityNumber convert(final String source) {
		return new SocialSecurityNumber(source);
	}

}
