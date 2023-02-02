
package com.portfolio.mgb.Service;

import com.portfolio.mgb.Entity.HyS;
import com.portfolio.mgb.Repository.RHyS;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SHyS {
    @Autowired
    RHyS rHyS;
    
    public List<HyS> list(){
        return rHyS.findAll();
    }
    public Optional<HyS> getOne(int id){
        return rHyS.findById(id);
    }
    public Optional<HyS> getByNombre(String nombreP){
        return rHyS.findByNombre(nombreP);
    }
   
    public void save(HyS proyecto){
        rHyS.save(proyecto);
    }
    public void delete(int id){
        rHyS.deleteById(id);
    }
    public boolean existById(int id){
        return rHyS.existsById(id);
    }
    public boolean existByNombre(String nombre){
        return rHyS.existsByNombre(nombre);
    }
    
}
