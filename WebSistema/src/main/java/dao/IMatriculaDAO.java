/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelos.Alumnos;
import modelos.Cursos;
import modelos.Matriculas;

/**
 *
 * @author josea
 */
public interface IMatriculaDAO {
    public List<Alumnos> buscarAlumnos(Alumnos alumno);
    public List<Cursos> buscarCursos();
    public boolean grabarMatricula(String[] datosMatricula, String[] codigosCursos, String[] montos);
    
    public List<Matriculas> buscarMatriculas(Matriculas matricula);
    
}
