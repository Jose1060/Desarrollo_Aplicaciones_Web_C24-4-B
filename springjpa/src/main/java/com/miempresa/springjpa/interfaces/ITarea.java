package com.miempresa.springjpa.interfaces;

import com.miempresa.springjpa.modelo.Tarea;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITarea extends CrudRepository<Tarea, Integer> {

}
