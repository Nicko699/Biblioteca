package com.Api_Rest_Biblioteca.Service;

import com.Api_Rest_Biblioteca.Model.Biblioteca;
import com.Api_Rest_Biblioteca.Model.Libros;
import com.Api_Rest_Biblioteca.Repository.BibliotecaRepository;
import com.Api_Rest_Biblioteca.Repository.LibrosRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LibrosServiceImpl implements LibrosService {

    @Autowired
    private LibrosRepository librosRepository;

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    @Override
    public Page<Libros> obtenerLibros(Pageable pageable) {

        return librosRepository.findAll(pageable);
    }

    @Override
    public Libros obtenerLibro(Long id) {

        return librosRepository.findById(id).orElse(null);
    }

    @Override
    public Libros crearLibro(Libros lib) {
        Optional<Biblioteca> bli = bibliotecaRepository.findById(lib.getBiblioteca().getId());
        if (bli.isPresent()) {
            lib.setBiblioteca(bli.get());
            return librosRepository.save(lib);
        }

        return null;
    }

    @Override
    public Libros editarLibro(Long id, Libros lib) {
        Libros li = librosRepository.findById(id).orElse(null);
        if (li != null) {
            li.setNombre(lib.getNombre());
            li.setAutor(lib.getAutor());
            return librosRepository.save(li);
        }
        return null;
    }

    @Override
    public void eliminarLibro(Long id) {
        librosRepository.deleteById(id);
    }

}
