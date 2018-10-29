package be.vdab.personeelfix.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.springframework.format.annotation.DateTimeFormat;

import be.vdab.personeelfix.adapters.LocalDateAdapter;
import be.vdab.personeelfix.constraints.SocialSecurityNumberConstraint;
import be.vdab.personeelfix.valueobjects.SocialSecurityNumber;

@Entity
@Table(name = "werknemers")
public class Employee implements Serializable {

	/** Implements Serializable */
	private static final long serialVersionUID = -4635254872941040510L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@DateTimeFormat(style = "S-")
	@NotNull
	@XmlJavaTypeAdapter(value = LocalDateAdapter.class)
	@Column(name = "geboorte")
	private LocalDate birthDate;
	
	@SocialSecurityNumberConstraint
	@Column(name = "rijksregisternr")
	private SocialSecurityNumber socialSecurityNumber;
	
	protected Employee() {}
	public Employee(
			final LocalDate birthDate,
			final SocialSecurityNumber socialSecurityNumber) {
		setBirthDate(birthDate);
		setSocialSecurityNumber(socialSecurityNumber);
	}
	
	public long getId() {
		return id;
	}
	
	public void setBirthDate(final LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	public void setSocialSecurityNumber(
			final SocialSecurityNumber socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public SocialSecurityNumber getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	
	public Employee saveSSN(final SocialSecurityNumber socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
		
		return this;
	}
}
