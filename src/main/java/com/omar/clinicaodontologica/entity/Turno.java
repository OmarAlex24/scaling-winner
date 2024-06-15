package com.omar.clinicaodontologica.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.LocalDate;

@Getter
@Setter
@ToString
public class Turno {
    private Long id;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate fecha;
}
