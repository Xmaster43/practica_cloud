package com.example.practica.cloud.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;
    @Column
    private String nombreLibro;
    @Column
    private LocalDate fechaLibro;

    // 1. Constructor vacío (Obligatorio para JPA y la conversión de JSON)
    public Libro() {
    }

    // 2. Constructor con parámetros (Opcional pero muy práctico)
    public Libro(Long idLibro, String nombreLibro, LocalDate fechaLibro) {
        this.idLibro = idLibro;
        this.nombreLibro = nombreLibro;
        this.fechaLibro = fechaLibro;
    }

    // --- 3. GETTERS Y SETTERS MANUALES ---

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public LocalDate getFechaLibro() {
        return fechaLibro;
    }

    public void setFechaLibro(LocalDate fechaLibro) {
        this.fechaLibro = fechaLibro;
    }
}
