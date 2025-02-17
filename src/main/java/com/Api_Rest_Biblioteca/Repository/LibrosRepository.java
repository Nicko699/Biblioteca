
package com.Api_Rest_Biblioteca.Repository;

import com.Api_Rest_Biblioteca.Model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrosRepository extends JpaRepository<Libros,Long> {
    
}
