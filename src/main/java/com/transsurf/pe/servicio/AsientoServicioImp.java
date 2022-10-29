package com.transsurf.pe.servicio;

import com.transsurf.pe.entidades.Asiento;
import com.transsurf.pe.entidades.Nivel;
import com.transsurf.pe.entidades.Unidad;
import com.transsurf.pe.repositorio.AsientoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AsientoServicioImp implements AsientoServicio{

    @Autowired
    private AsientoRepositorio asientoRepositorio;

    @Override
    public void crearAsientos(Unidad unidad) {
        List<Asiento> asientos = new ArrayList<>();
        for (int i = 1; i <= unidad.getNumAsientos(); i++) {
            Asiento asiento = new Asiento();
            asiento.setUnidad(unidad);
            asiento.setNivel(new Nivel((unidad.getNumPisos() == 2)? ((i <= 12)? 1 : 2) : 2, ""));
            asiento.setNumAsiento(i);
            asiento.setEstado("Disponible");

            asientos.add(asiento);
        }
        asientoRepositorio.saveAll(asientos);
    }

    @Override
    public void actualizarAsientos(Unidad unidad) {
        boolean nivel2 = asientoRepositorio.existsByUnidadAndNivel(unidad, new Nivel(2,""));
        Long numAsientos = asientoRepositorio.countByUnidad(unidad);
        if (numAsientos != unidad.getNumAsientos() || nivel2 != (unidad.getNumPisos() == 2)) {
            List<Asiento> asientos = asientoRepositorio.findAllByUnidad(unidad);
            asientoRepositorio.deleteAll(asientos);
            crearAsientos(unidad);
        } else if (numAsientos == unidad.getNumAsientos() && nivel2 == (unidad.getNumPisos() == 2)) {}
    }
}
