package com.example.practica.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.practica.cloud.model.Libro;


public interface LibroRepository extends JpaRepository<Libro, Long> {

}
