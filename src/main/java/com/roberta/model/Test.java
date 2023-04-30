package com.roberta.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
@Table(name = "TESTE")
public class Test {

	@Id
	@NotEmpty(message = "Introduceti codul testului!")
	@Column(name = "ID_TEST", nullable = false, unique = true)
	private String idTest;
	
	
	@NotEmpty(message = "Introduceti denumirea testului!")
	@Column(name = "DENUMIRE_TEST", nullable = false)
	private String denumireTest;
	
	@OneToMany(mappedBy="test", fetch=FetchType.EAGER, orphanRemoval=true)
	private List<Intrebare> intrebari;
	
	@NotNull(message = "Introduceti punctajul necesar promovarii testului!")
	@Column(name = "PUNCTAJ_NECESAR")
	private float punctajNecesar;
	
	@Column(name = "DURATA")
	private int durata;
	
	@Column(name = "NUMAR_REPETARI")
	private int numarRepetari;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CURS")
	private Curs cursTeste;
	
	
	public Curs getCursTeste() {
		return cursTeste;
	}
	public void setCursTeste(Curs cursTeste) {
		this.cursTeste = cursTeste;
	}
	public String getIdTest() {
		return idTest;
	}
	public void setIdTest(String idTest) {
		this.idTest = idTest;
	}
	public String getDenumireTest() {
		return denumireTest;
	}
	public void setDenumireTest(String denumireTest) {
		this.denumireTest = denumireTest;
	}
	public List<Intrebare> getIntrebari() {
		return intrebari;
	}
	public void setIntrebari(List<Intrebare> intrebari) {
		this.intrebari = intrebari;
	}
	public float getPunctajNecesar() {
		return punctajNecesar;
	}
	public void setPunctajNecesar(float punctajNecesar) {
		this.punctajNecesar = punctajNecesar;
	}
	public int getDurata() {
		return durata;
	}
	public void setDurata(int durata) {
		this.durata = durata;
	}
	public int getNumarRepetari() {
		return numarRepetari;
	}
	public void setNumarRepetari(int numarRepetari) {
		this.numarRepetari = numarRepetari;
	}
	
	
}
