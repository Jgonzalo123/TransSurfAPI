package com.transsurf.pe.repositorio;

import com.transsurf.pe.entidades.Programacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramacionRepositorio extends JpaRepository<Programacion, Integer> {
}
