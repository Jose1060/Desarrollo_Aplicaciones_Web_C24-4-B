package com.miempresa.springjpa.interfaces;

import java.util.List;
import java.util.Optional;

import com.miempresa.springjpa.modelo.Empleado;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface IEmpleado extends CrudRepository<Empleado, Integer> {
    
    //Buscar empleados por nombre
    @Transactional 
    List<Empleado> findByNombre(String nombre);

    //Buscar empleados por letras de nombre
    @Transactional
    //SELECT * FROM Empleado WHERE nombre LIKE'%nombre%'"
    @Query("FROM Empleado e WHERE e.nombre LIKE %:nombre%")
    List<Empleado> findByNombreWith(@Param("nombre") String nombre);
    
}
