package com.roberta.model;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="CAPITOLE")
public class Capitol implements Comparable<Capitol>{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_CAPITOL", nullable = false, unique = true)
	private Long idCapitol;
	
	@Column(name = "DENUMIRE_CAPITOL", nullable = false)
	private String denumireCapitol;
	
	@OneToMany(mappedBy="capitol",fetch = FetchType.EAGER, orphanRemoval=true)
	@OrderBy("idLectie ASC")
	private List<Lectie> lectii=new ArrayList<Lectie>();
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "ID_CURS")
	private Curs capitolCurs;
	
	public Long getIdCapitol() {
		return idCapitol;
	}
	public void setIdCapitol(Long idCapitol) {
		this.idCapitol = idCapitol;
	}
	public String getDenumireCapitol() {
		return denumireCapitol;
	}
	public void setDenumireCapitol(String denumireCapitol) {
		this.denumireCapitol = denumireCapitol;
	}
	public List<Lectie> getLectii() {
		return lectii;
	}
	public void setLectii(List<Lectie> lectii) {
		this.lectii = lectii;
	}
	public Curs getCapitolCurs() {
		return capitolCurs;
	}
	public void setCapitolCurs(Curs capitolCurs) {
		this.capitolCurs = capitolCurs;
	}
	
	public int compareTo(Capitol c) {
		return this.getIdCapitol().compareTo(c.getIdCapitol());
	}
	
	
}
