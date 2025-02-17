package com.Api_Rest_Biblioteca.Service;

import com.Api_Rest_Biblioteca.Model.Libros;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface LibrosService {

    public Page<Libros> obtenerLibros(Pageable pageable);

    public Libros obtenerLibro(Long id);

    public Libros crearLibro(Libros lib);

    public Libros editarLibro(Long id, Libros lib);

    public void eliminarLibro(Long id);

}
