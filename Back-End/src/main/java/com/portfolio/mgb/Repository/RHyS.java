
package com.portfolio.mgb.Repository;

import com.portfolio.mgb.Entity.HyS;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RHyS  extends JpaRepository<HyS, Integer>{
    public Optional<HyS> findByNombre(String nombre);
    
    public boolean existsByNombre(String nombre);

}
