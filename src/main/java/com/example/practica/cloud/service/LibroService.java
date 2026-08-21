package com.example.practica.cloud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.practica.cloud.model.Libro;
import com.example.practica.cloud.repository.LibroRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class LibroService {
    
    @Autowired
    private LibroRepository libroRepo;

    public Optional<Libro> buscarLibro(Long id) {

        return libroRepo.findById(id);
    }

    public List<Libro> listarLibros() {
        return libroRepo.findAll();
    }

    public Libro agregarLibro(Libro libro) {
        Libro libroAdded = libroRepo.save(libro);
        return libroAdded;
    }

    public void eliminarLibro (Long id) {
        libroRepo.deleteById(id);
    }
}
