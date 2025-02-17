package com.Api_Rest_Biblioteca.Controller;

import com.Api_Rest_Biblioteca.Model.Biblioteca;
import com.Api_Rest_Biblioteca.Service.BibliotecaService;
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
@RequestMapping("/biblioteca")
public class BibliotecaController {

    @Autowired
    BibliotecaService bibliotecaService;

   @GetMapping
    public ResponseEntity<Page<Biblioteca>> obtenerBibliotecas(Pageable pageable) {

        Page<Biblioteca> bibl = bibliotecaService.obtenerBibliotecas(pageable);

        return ResponseEntity.ok(bibl);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Biblioteca> obtenerBiblioteca(@PathVariable Long id) {

        Biblioteca bibl = bibliotecaService.obtenerBiblioteca(id);

        if (bibl != null) {
            return ResponseEntity.ok(bibl);

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @PostMapping
    public ResponseEntity<Biblioteca> crearBiblioteca(@RequestBody Biblioteca bibl) {

        Biblioteca bib = bibliotecaService.crearBiblioteca(bibl);

        if (bib != null) {

            URI location = ServletUriComponentsBuilder.
                    fromCurrentRequest().
                    path("/{id}").
                    buildAndExpand(bib.getId()).
                    toUri();
            return ResponseEntity.created(location).body(bib);

        }

        return ResponseEntity.badRequest().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Biblioteca> editarBiblioteca(@PathVariable Long id, @RequestBody Biblioteca bli) {

        Biblioteca bibl = bibliotecaService.editarBiblioteca(id, bli);
        if (bibl != null) {
            return ResponseEntity.ok(bibl);

        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Biblioteca> eliminarBiblioteca(@PathVariable Long id) {

        Biblioteca bibl = bibliotecaService.obtenerBiblioteca(id);
        if (bibl != null) {
            bibliotecaService.eliminarBiblioteca(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }

}
