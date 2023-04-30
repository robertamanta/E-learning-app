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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "INTREBARI")
public class Intrebare {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID_INTREBARE", nullable = false, unique = true)
	private Long idIntrebare;
	
	@NotEmpty(message = "Introduceti continutul intrebarii!")
	@Column(name = "CONTINUT", nullable = false)
	private String continut;
	
	@Column(name = "TIP_INTRRBARE")
	private String tipIntrebare;
	
	@Column(name = "PUNCTAJ_INTREBARE")
	private float punctajIntrebare;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "ID_TEST")
	private Test test;
}
