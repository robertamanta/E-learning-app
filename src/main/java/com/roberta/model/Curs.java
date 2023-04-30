package com.roberta.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Sort;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.Blob;

@Entity
@Table(name = "CURSURI")
public class Curs {

	@Id
	@NotEmpty(message = "Introduceti codul cursului!")
	@Column(name = "ID_CURS", nullable = false, unique = true)
	private String idCurs;

	@NotEmpty(message = "Introduceti numele cursului!")
	@Column(name = "NUME_CURS", nullable = false)
	private String denumireCurs;

	@NotEmpty(message = "Introduceti descrierea cursului!")
	@Column(name = "DESCRIERE", nullable = false)
	private String descriereCurs;

	@NotNull
	@Column(name = "DURATA", nullable = false)
	private int durataCurs;// min

	@NotNull
	@Column(name = "PRET")
	private float pret;

	// @Lob
	// @Column(name="IMAGINE_CURS",columnDefinition="mediumblob")
	// private MultipartFile imagine;
	 @Column(name="CALE_IMAGINE")
	 private String caleImagine;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_CATEGORIE")
	private CategorieCurs categorieCurs;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NUME_UTILIZATOR")
	private Profesor profesor;
    
	@OneToMany(mappedBy="capitolCurs", fetch=FetchType.EAGER, orphanRemoval=true)
	@OrderBy("idCapitol ASC")
	private List<Capitol> capitole =new ArrayList<Capitol>();
	
	@OneToMany(mappedBy="cursTeste")
	List<Test> teste = new ArrayList<Test>();
	
	public List<Test> getTeste() {
		return teste;
	}

	public void setTeste(List<Test> teste) {
		this.teste = teste;
	}

	public String getIdCurs() {
		return idCurs;
	}

	public void setIdCurs(String idCurs) {
		this.idCurs = idCurs;
	}

	public String getDenumireCurs() {
		return denumireCurs;
	}

	public void setDenumireCurs(String denumireCurs) {
		this.denumireCurs = denumireCurs;
	}

	public String getDescriereCurs() {
		return descriereCurs;
	}

	public void setDescriereCurs(String descriereCurs) {
		this.descriereCurs = descriereCurs;
	}

	public int getDurataCurs() {
		return durataCurs;
	}

	public void setDurataCurs(int durataCurs) {
		this.durataCurs = durataCurs;
	}

	public float getPret() {
		return pret;
	}

	public void setPret(float pret) {
		this.pret = pret;
	}

	public CategorieCurs getCategorieCurs() {
		return categorieCurs;
	}

	public void setCategorieCurs(CategorieCurs categorieCurs) {
		this.categorieCurs = categorieCurs;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public String getCaleImagine() {
		return caleImagine;
	}

	public void setCaleImagine(String caleImagine) {
		this.caleImagine = caleImagine;
	}

	public List<Capitol> getCapitole() {
		return capitole;
	}

	public void setCapitole(List<Capitol> capitole) {
		this.capitole = capitole;
	}

	
	
}