package com.roberta.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

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

@Entity
@Table( name = "LECTII")
public class Lectie implements Comparable<Lectie> {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_LECTIE", nullable = false, unique = true)
	private Long idLectie;
	
	@Column(name= "DENUMIRE_LECTIE", nullable=false)
	private String denumireLectie;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="ID_CAPITOL")
	private Capitol capitol;
	
	@OneToMany(mappedBy = "lectieResursa", fetch=FetchType.EAGER, orphanRemoval=true)
	@OrderBy("idResursa ASC")
	private List<Resursa> resurse = new ArrayList<Resursa>();
	
	public Long getIdLectie() {
		return idLectie;
	}
	public void setIdLectie(Long idLectie) {
		this.idLectie = idLectie;
	}
	public String getDenumireLectie() {
		return denumireLectie;
	}
	public void setDenumireLectie(String denumireLectie) {
		this.denumireLectie = denumireLectie;
	}
	
	public Capitol getCapitol() {
		return capitol;
	}
	public void setCapitol(Capitol capitol) {
		this.capitol = capitol;
	}
	public List<Resursa> getResurse() {
		return resurse;
	}
	public void setResurse(List<Resursa> resurse) {
		this.resurse = resurse;
	}
	public int compareTo(Lectie l) {
		
		return this.getIdLectie().compareTo(l.getIdLectie());
	}

	
	
}
