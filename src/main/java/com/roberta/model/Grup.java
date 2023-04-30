package com.roberta.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "GRUPURI")
public class Grup {

	@Id
	@NotNull
	@Column(name="CHEIE_GRUP", unique = true)
	private String idGrup;
	
	@Column(name = "DENUMIRE_GRUP",nullable =false)
	@NotEmpty(message ="Introduce-ti denumirea grupului!")
	private String denumireGrup;
	
	@Column(name = "DESCRIERE_GRUP")
	private String descriereGrup;
	
	@ManyToMany
	@JoinTable(name = "GRUPURI_CURSANTI",
				joinColumns={@JoinColumn(name = "CHEIE_GRUP")},
				inverseJoinColumns={@JoinColumn(name = "NUME_UTILIZATOR")})
	private List<Cursant> cursantiGrup=new ArrayList<Cursant>();
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="NUME_UTILIZATOR")
	private Profesor profesorGrup;

	public String getIdGrup() {
		return idGrup;
	}

	public void setIdGrup(String idGrup) {
		this.idGrup = idGrup;
	}

	public String getDenumireGrup() {
		return denumireGrup;
	}

	public void setDenumireGrup(String denumireGrup) {
		this.denumireGrup = denumireGrup;
	}

	public String getDescriereGrup() {
		return descriereGrup;
	}

	public void setDescriereGrup(String descriereGrup) {
		this.descriereGrup = descriereGrup;
	}

	public List<Cursant> getCursanti() {
		return cursantiGrup;
	}

	public void setCursanti(List<Cursant> cursanti) {
		this.cursantiGrup = cursanti;
	}

	public Profesor getProfesorGrup() {
		return profesorGrup;
	}

	public void setProfesorGrup(Profesor profesorGrup) {
		this.profesorGrup = profesorGrup;
	}
	
	
}
