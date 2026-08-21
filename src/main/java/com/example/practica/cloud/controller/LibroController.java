package com.example.practica.cloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.practica.cloud.model.Libro;
import com.example.practica.cloud.service.LibroService;

import java.util.List;

@RestController
@RequestMapping("/api/libros") // Ruta base para todos los endpoints de este controlador

public class LibroController {

    @Autowired
    private LibroService libroService;

    // Obtener todos los libros (GET /api/libros)
    @GetMapping
    public ResponseEntity<List<Libro>> listarLibros() {
        List<Libro> libros = libroService.listarLibros();
        return ResponseEntity.ok(libros);
    }

    // Buscar un libro por ID (GET /api/libros/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarLibro(@PathVariable Long id) {
        return libroService.buscarLibro(id)
                .map(ResponseEntity::ok) // Si lo encuentra, devuelve 200 OK con el libro
                .orElse(ResponseEntity.notFound().build()); // Si no, devuelve 404 Not Found
    }

    // Agregar un nuevo libro (POST /api/libros)
    @PostMapping
    public ResponseEntity<Libro> agregarLibro(@RequestBody Libro libro) {
        Libro libroGuardado = libroService.agregarLibro(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(libroGuardado); // Devuelve 201 Created
    }

    // Eliminar un libro (DELETE /api/libros/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return ResponseEntity.noContent().build(); // Devuelve 204 No Content (operación exitosa sin cuerpo de respuesta)
    }
}