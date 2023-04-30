package com.roberta.service;

import java.util.List;

import com.roberta.model.Curs;

public interface CursService {

  Curs SalveazaCurs(Curs curs,String numeUtilizator) throws Exception;
  boolean existaCurs(String idCurs);
  List<Curs> preiaCursuri(String numeProfesor) throws Exception;
  Curs selectCurs(String idCurs);
  public List<Curs> preiaToateCursurile();
  public Curs actualizareCurs(Curs curs);
}
