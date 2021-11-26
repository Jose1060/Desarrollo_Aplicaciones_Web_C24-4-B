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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class controlador {
    
    @Autowired
    private IEmpleadoServicio servicio;
    @Autowired
    private ITareaServicio servicioTarea;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "index";
    }

    //Empleados
    @GetMapping("/listarEmpleados")
    public String listarEmpleados(Model model) {
        List<Empleado> empleados = servicio.listar();
        model.addAttribute("empleados", empleados);
        model.addAttribute("empleado", new Empleado());
        return "empleados";
    }

    @GetMapping("/buscarEmpleados")
    public String buscarEmpleados(Model model,@RequestParam String nombre, @ModelAttribute("empleado") Empleado empleado) {
        List<Empleado> empleados = servicio.buscarWith(nombre);
        model.addAttribute("empleados", empleados);
        return "buscarEmpleado";
    }

    @GetMapping("/agregarEmpleado")
    public String agregarEmpleado(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "agregarEmpleado";
    }

    @PostMapping("/guardarEmpleado")
    public String guardarEmpleado(Empleado p) {
        servicio.guardar(p);
        return "redirect:/listarEmpleados";
    }

    @GetMapping("/editarEmpleado/{id}")
    public String editarEmpleado(@PathVariable int id, RedirectAttributes atributos) {
        Optional<Empleado> empleado = servicio.listarId(id);
        atributos.addFlashAttribute("empleado", empleado);
        return "redirect:/mostrarEmpleado";
    }

    @GetMapping("/mostrarEmpleado")
    public String mostrarEmpleado(@ModelAttribute("empleado") Empleado p,  Model model) {
        model.addAttribute("empleado", p);
        return "agregarEmpleado";
    }

    @GetMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable int id) {
        servicio.borrar(id);
        return "redirect:/listarEmpleados";
    }


    //TAREAS
    @GetMapping("/listarTareas")
    public String listarTareas(Model model) {
        List<Tarea> tareas = servicioTarea.listar();
        model.addAttribute("tareas", tareas);
        model.addAttribute("empleado", new Empleado());
        return "tareas";
    }

    @GetMapping("/buscarTareas")
    public String buscarTareas(Model model,@RequestParam String nombre, @ModelAttribute("empleado") Empleado empleado) {
        //List<Tarea> tareas = servicioTarea.buscarWith(nombre);
        //model.addAttribute("tareas", tareas);
        return "buscarTarea";
    }

    @GetMapping("/agregarTarea")
    public String agregarTarea(Model model) {
        model.addAttribute("tarea", new Tarea());
        model.addAttribute("empleado", new Empleado());
        return "agregarTarea";
    }

    @PostMapping("/guardarTarea")
    public String guardarTarea(Tarea p) {
        servicioTarea.guardar(p);
        return "redirect:/listarTareas";
    }

    @GetMapping("/editarTarea/{id}")
    public String editarTarea(@PathVariable int id, RedirectAttributes atributos) {
        Optional<Tarea> tarea = servicioTarea.listarId(id);
        atributos.addFlashAttribute("tarea", tarea);
        return "redirect:/mostrarTarea";
    }

    @GetMapping("/mostrarTarea")
    public String mostrarTarea(@ModelAttribute("tarea") Tarea p,  Model model) {
        model.addAttribute("tarea", p);
        model.addAttribute("empleado", new Empleado());
        return "agregarTarea";
    }

    @GetMapping("/eliminarTarea/{id}")
    public String eliminarTarea(@PathVariable int id) {
        servicioTarea.borrar(id);
        return "redirect:/listarTareas";
    }
}
