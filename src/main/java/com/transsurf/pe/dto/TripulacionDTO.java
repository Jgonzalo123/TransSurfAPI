package com.transsurf.pe.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class TripulacionDTO {
    private int idTripulacion;
    private ProgramacionDTO programacion;
    private UsuarioDTO usuario;
}
