
package com.portfolio.mgb.Repository;

import com.portfolio.mgb.Entity.Contacto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RContacto extends JpaRepository<Contacto, Integer>{
    public Optional<Contacto> findByEmail(String email);
    
    public boolean existsByEmail(String email);
}
