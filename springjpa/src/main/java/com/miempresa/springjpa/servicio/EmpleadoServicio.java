package com.miempresa.springjpa.servicio;

import java.util.List;
import java.util.Optional;

import com.miempresa.springjpa.interfaceServicio.IEmpleadoServicio;
import com.miempresa.springjpa.interfaces.IEmpleado;
import com.miempresa.springjpa.modelo.Empleado;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmpleadoServicio implements IEmpleadoServicio{
	
	@Autowired
	private IEmpleado repo;

	@Override
	public List<Empleado> listar() {
		return (List<Empleado>) repo.findAll();
	}

	@Override
	public Optional<Empleado> listarId(int id) {
		return repo.findById(id);
	}

	@Override
	public int guardar(Empleado p) {
		Empleado em = repo.save(p);
		if (!em.equals(null)){
			return 1;
		}
		return 0;
	}

	@Override
	public void borrar(int id) {
		repo.deleteById(id);
	}

	@Override
	public List <Empleado> buscar(String nombre) {
		List<Empleado> empleados = this.repo.findByNombre(nombre);
		return empleados;
	}	

	@Override
	public List<Empleado> buscarWith(String nombre) {
		List<Empleado> empleados = this.repo.findByNombreWith(nombre);
		return empleados;
	}
}



