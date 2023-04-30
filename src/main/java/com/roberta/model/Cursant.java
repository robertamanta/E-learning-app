package com.roberta.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CURSANTI")
@PrimaryKeyJoinColumn(name="NUME_UTILIZATOR")
public class Cursant extends Utilizator{

	@ManyToMany(mappedBy = "cursantiGrup")
	private List<Grup> grupuri =new ArrayList<Grup>();

	
}
