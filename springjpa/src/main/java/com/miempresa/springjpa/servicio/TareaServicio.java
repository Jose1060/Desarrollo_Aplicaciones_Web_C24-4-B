package com.miempresa.springjpa.servicio;

import java.util.List;
import java.util.Optional;

import com.miempresa.springjpa.interfaceServicio.ITareaServicio;
import com.miempresa.springjpa.interfaces.ITarea;
import com.miempresa.springjpa.modelo.Tarea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaServicio implements ITareaServicio {
    @Autowired
	private ITarea repo;

	@Override
	public List<Tarea> listar() {
		return (List<Tarea>) repo.findAll();
	}

	@Override
	public Optional<Tarea> listarId(int id) {
		// Todo Auto-generated method stub
		return null;
	}

	@Override
	public int guardar(Tarea p) {
		// Todo Auto-generated method stub
		return 0;
	}

	@Override
	public void borrar(int id) {
		// todo Auto-generated method stub
		
	}
}
