package com.Api_Rest_Biblioteca.Service;

import com.Api_Rest_Biblioteca.Model.Biblioteca;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BibliotecaService {

    public Page<Biblioteca> obtenerBibliotecas(Pageable peageble);

    public Biblioteca obtenerBiblioteca(Long id);

    public Biblioteca crearBiblioteca(Biblioteca bibli);

    public Biblioteca editarBiblioteca(Long id, Biblioteca bibli);

    public void eliminarBiblioteca(Long id);

}
