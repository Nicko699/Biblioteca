package com.Api_Rest_Biblioteca.Service;

import com.Api_Rest_Biblioteca.Model.Biblioteca;
import com.Api_Rest_Biblioteca.Repository.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaServiceImpl implements BibliotecaService {
    
    @Autowired
    private BibliotecaRepository bibliotecaRepository;
    
    @Override
    public Page<Biblioteca> obtenerBibliotecas(Pageable peageble) {
        
        return bibliotecaRepository.findAll(peageble);
        
    }
    
    @Override
    public Biblioteca obtenerBiblioteca(Long id) {
        return bibliotecaRepository.findById(id).orElse(null);
    }
    
    @Override
    public Biblioteca crearBiblioteca(Biblioteca bibli) {
        return bibliotecaRepository.save(bibli);
    }
    
    @Override
    public Biblioteca editarBiblioteca(Long id, Biblioteca bibli) {
        
        Biblioteca bli = bibliotecaRepository.findById(id).orElse(null);
        
        if (bli != null) {
            bli.setNombre(bibli.getNombre());
            
            return bibliotecaRepository.save(bli);
            
        }
        
        return null;
    }
    
    @Override
    public void eliminarBiblioteca(Long id) {
        bibliotecaRepository.deleteById(id);
    }
    
}
