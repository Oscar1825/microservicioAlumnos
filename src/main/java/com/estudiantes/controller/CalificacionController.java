package com.estudiantes.controller;


import com.estudiantes.modelo.Alumno;
import com.estudiantes.modelo.Calificacion;
import com.estudiantes.repository.ICalificacionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/calificacion")
public class CalificacionController {

    @Autowired
    private ICalificacionDao repo;

    @GetMapping("/listar")
    public List<Calificacion> listar(){
        List<Calificacion> calificaciones = (List<Calificacion>) repo.findAll();
        return calificaciones;
    }

    @PostMapping
    public Calificacion agregarCalificacion(@RequestBody Calificacion calificacion){
        return repo.save(calificacion);
    }

    @GetMapping("/{id}")
    public Optional<Calificacion> getCalificacionById(@PathVariable long id){
        return repo.findById(id);
    }
    @PutMapping("/{id}")
    public Calificacion modificarCalificacion(@RequestBody Calificacion calificacion, @PathVariable long id) {
        calificacion.setId(id);
        return repo.save(calificacion);
    }

    @DeleteMapping("/{id}")
    public void eliminarCalificacion(@PathVariable long id) {
        repo.deleteById(id);
    }
}
