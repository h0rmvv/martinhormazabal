package com.example.martinhormazabal.model;

import java.time.LocalDate;
import lombok.Data;

@Data
public class Resource {
    private Long id;
    private String nombre;
    private String descripcion;
    private boolean disponible;
    private String responsable;
    private LocalDate fechaCreacion;
    private String tipo;
    private int cantidad;
}