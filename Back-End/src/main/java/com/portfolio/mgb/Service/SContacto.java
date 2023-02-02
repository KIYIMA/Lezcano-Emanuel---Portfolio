
package com.portfolio.mgb.Service;

import com.portfolio.mgb.Entity.Contacto;
import com.portfolio.mgb.Repository.RContacto;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SContacto {
    @Autowired
    RContacto rContacto;
    
    public Optional<Contacto> getByEmail(String email){
        return rContacto.findByEmail(email);
    }
   
    public void save(Contacto contacto){
        rContacto.save(contacto);
    }
    public boolean existById(int id){
        return rContacto.existsById(id);
    }
    public boolean existByEmail(String email){
        return rContacto.existsByEmail(email);
    }
}
