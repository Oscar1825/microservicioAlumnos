package com.estudiantes.repository;

import com.estudiantes.modelo.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface IAlumnoDao extends CrudRepository<Alumno, Long> {
}
