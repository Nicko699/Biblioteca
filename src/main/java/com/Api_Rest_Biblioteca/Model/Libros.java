
package com.Api_Rest_Biblioteca.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

@Entity
public class Libros {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Basic
    @NotNull
    private String nombre;
    @Basic
    @NotNull
    private String autor;
    @JoinColumn(name="Biblioteca_Id")
    @ManyToOne
    @JsonBackReference
    private Biblioteca biblioteca;

    public Libros() {
    }

    public Libros(Long id, String nombre, String autor, Biblioteca biblioteca) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.biblioteca = biblioteca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    
    
}
