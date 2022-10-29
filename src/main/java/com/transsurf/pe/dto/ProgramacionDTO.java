package com.transsurf.pe.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
@NoArgsConstructor
public class ProgramacionDTO {
    private int idProgramacion;
    private UnidadDTO unidad;
    private OrigenDTO origen;
    private DestinoDTO destino;
    private Timestamp fecha;
    private Double costo;
    private String estado;
}
