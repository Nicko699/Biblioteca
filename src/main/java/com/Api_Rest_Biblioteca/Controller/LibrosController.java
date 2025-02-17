package com.Api_Rest_Biblioteca.Controller;

import com.Api_Rest_Biblioteca.Model.Libros;
import com.Api_Rest_Biblioteca.Service.LibrosService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/libros")
public class LibrosController {

    @Autowired
    private LibrosService librosService;
    
   @GetMapping
    public ResponseEntity<Page<Libros>> obtenerLibros(Pageable pegeable) {

        Page<Libros> li = librosService.obtenerLibros(pegeable);

        return ResponseEntity.ok(li);

    }
   @GetMapping("{id}")
    public ResponseEntity<Libros> obtenerLibro(@PathVariable Long id) {
        Libros li = librosService.obtenerLibro(id);
        if (li != null) {
            return ResponseEntity.ok(li);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @PostMapping
    public ResponseEntity<Libros> crearLibros(@RequestBody Libros lib) {
        Libros li = librosService.crearLibro(lib);
        if (li != null) {
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}").
                    buildAndExpand(li.getId()).
                    toUri();

            return ResponseEntity.created(location).body(li);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Libros> editarLibro(@PathVariable Long id, @RequestBody Libros lib) {

        Libros li = librosService.editarLibro(id, lib);
        if (li != null) {
            return ResponseEntity.ok(li);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Libros> eliminarLibros(@PathVariable Long id) {

        Libros li = librosService.obtenerLibro(id);

        if (li != null) {
            librosService.eliminarLibro(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

}
