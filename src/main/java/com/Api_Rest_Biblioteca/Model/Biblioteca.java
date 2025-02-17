
package com.Api_Rest_Biblioteca.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Biblioteca {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Basic
    @NotNull
    private String nombre;
    @OneToMany(mappedBy="biblioteca",cascade=CascadeType.ALL)
    @JsonManagedReference
    private List<Libros>listaLibros;

    public Biblioteca() {
    }

    public Biblioteca(Long id, String nombre, List<Libros> listaLibros) {
        this.id = id;
        this.nombre = nombre;
        this.listaLibros = listaLibros;
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

    public List<Libros> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Libros> listaLibros) {
        this.listaLibros = listaLibros;
    }
    
    
    
}
