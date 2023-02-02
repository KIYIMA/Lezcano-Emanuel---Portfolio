
package com.portfolio.mgb.Repository;

import com.portfolio.mgb.Entity.AcercaDe;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAcercaDe extends JpaRepository<AcercaDe, Integer>{
    public Optional<AcercaDe> findByProfecion(String profecion);
    public boolean existsByProfecion(String profecion);
}
