package com.estudiantes.controller;

import com.estudiantes.modelo.Alumno;
import com.estudiantes.repository.IAlumnoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private IAlumnoDao repo;

    @GetMapping("/listar")
    public List<Alumno>listarAlumno(){
        List<Alumno> alumnos = (List<Alumno>) repo.findAll();
        return alumnos;
    }

    @PostMapping
    public Alumno agregarAlumno(@RequestBody Alumno alumno){
        return repo.save(alumno);
    }

    @GetMapping("/{id}")
    public Optional<Alumno> getAlumnoById(@PathVariable long matricula){
        return repo.findById(matricula);
    }
    @PutMapping("/{id}")
    public Alumno modificarAlumno(@RequestBody Alumno alumno, @PathVariable long matricula) {
        alumno.setMatricula(matricula);
        return repo.save(alumno);
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable long matricula) {
        repo.deleteById(matricula);
    }

}
