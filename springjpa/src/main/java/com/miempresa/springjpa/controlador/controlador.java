package com.miempresa.springjpa.controlador;

import java.util.List;
import java.util.Optional;

import com.miempresa.springjpa.interfaceServicio.IEmpleadoServicio;
import com.miempresa.springjpa.interfaceServicio.ITareaServicio;
import com.miempresa.springjpa.modelo.Empleado;
import com.miempresa.springjpa.modelo.Tarea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class controlador {
    
    @Autowired
    private IEmpleadoServicio servicio;
    @Autowired
    private ITareaServicio servicioTarea;

    @GetMapping("/listarEmpleados")
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = servicio.listar();
        model.addAttribute("empleados", empleados);
        model.addAttribute("empleado", new Empleado());
        return "empleados";
    }

    @GetMapping("/listarTareas")
    public String listarTareas(Model model) {
        List<Tarea> tareas = servicioTarea.listar();
        model.addAttribute("tareas", tareas);
        model.addAttribute("empleado", new Empleado());
        return "tareas";
    }

    @GetMapping("/buscarEmpleados")
    public String buscarEmpleados(Model model,@RequestParam String nombre, @ModelAttribute("empleado") Empleado empleado) {
        List<Empleado> empleados = servicio.buscarWith(nombre);
        model.addAttribute("empleados", empleados);
        return "buscarEmpleado";
    }
}
