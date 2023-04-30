package com.roberta.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="UTILIZATORI")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilizator {


	@Id
	@NotNull
	@NotEmpty(message="Introduceti numele de utilizator!")
	@Column(name="NUME_UTILIZATOR", nullable=false,unique=true)
	private String numeUtilizator;
	
	@NotNull
	@NotEmpty(message="Introduceti parola!")
	//@Range(min=7, message="Parola trebuie sa contina cel putin 7 caractere!")
	@Column(name="PAROLA", nullable=false)
	private String parola;
	
	@NotNull
	@NotEmpty(message="Reintroduceti parola!")
//	@Range(min=7, message="Parola trebuie sa contina cel putin 7 caractere!")
	@Column(name="PAROLA_REINTRODUSA",nullable=false)
	private String potrivireParola;
	
	@NotNull
	@NotEmpty(message="Introduceti numele!")
	@Column(name="NUME", nullable=false)
	private String nume;
	
	@NotNull
	@NotEmpty(message="Introduceti prenumele!")
	@Column(name="PRENUME", nullable=false)
	private String prenume;
	
	@NotNull
	@NotEmpty(message="Introduceti adresa de email!")
	@Email(message="Adresa de email este incorecta!")
	@Column(name="EMAIL", nullable=false)
	private String email;
	

	@NotEmpty(message="Intoduceti o scurta descriere!")
	@Column(name="DESCRIERE")
	private String descriere;
	
	@Column(name="STARE",nullable=false)
	private boolean stare;
	
	@ManyToOne( fetch=FetchType.LAZY)
	@JoinColumn(name="ID_ROL")
    private TipUtilizator tipUtilizator;

	
	public String getNumeUtilizator() {
		return numeUtilizator;
	}

	public void setNumeUtilizator(String numeUtilizator) {
		this.numeUtilizator = numeUtilizator;
	}

	public String getParola() {
		return parola;
	}

	public void setParola(String parola) {
		this.parola = parola;
	}

	public String getPotrivireParola() {
		return potrivireParola;
	}

	public void setPotrivireParola(String potrivireParola) {
		this.potrivireParola = potrivireParola;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStare() {
		return stare;
	}

	public void setStare(boolean stare) {
		this.stare = stare;
	}

	public TipUtilizator getTipUtilizator() {
		return tipUtilizator;
	}

	public void setTipUtilizator(TipUtilizator tipUtilizator) {
		this.tipUtilizator = tipUtilizator;
	}

	public String getDescriere() {
		return descriere;
	}

	public void setDescriere(String descriere) {
		this.descriere = descriere;
	}

	
}