package com.roberta.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="RESURSE")
public class Resursa implements Comparable<Resursa> {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_RESURSA")
	private Long idResursa;
	
	@Column(name="DENUMIRE_RESURSA")
	private String denumireResursa;
	
	@Column(name="CALE_RESURSA", nullable=false)
	private String caleResursa;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="ID_LECTIE")
	private Lectie lectieResursa;

	public Long getIdResursa() {
		return idResursa;
	}

	public void setIdResursa(Long idResursa) {
		this.idResursa = idResursa;
	}

	public String getCaleResursa() {
		return caleResursa;
	}

	public void setCaleResursa(String caleResursa) {
		this.caleResursa = caleResursa;
	}

	public Lectie getLectieResursa() {
		return lectieResursa;
	}

	public void setLectieResursa(Lectie lectieResursa) {
		this.lectieResursa = lectieResursa;
	}

	public int compareTo(Resursa r) {
		 return this.getIdResursa().compareTo(r.getIdResursa());
	}

	public String getDenumireResursa() {
		return denumireResursa;
	}

	public void setDenumireResursa(String denumireResursa) {
		this.denumireResursa = denumireResursa;
	}
	
	
	
}
