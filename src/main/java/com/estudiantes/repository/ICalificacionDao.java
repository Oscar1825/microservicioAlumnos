package com.estudiantes.repository;

import com.estudiantes.modelo.Calificacion;
import org.springframework.data.repository.CrudRepository;

public interface ICalificacionDao extends CrudRepository<Calificacion, Long> {
}
