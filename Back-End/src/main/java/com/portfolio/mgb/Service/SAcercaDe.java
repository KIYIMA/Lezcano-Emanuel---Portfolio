
package com.portfolio.mgb.Service;

import com.portfolio.mgb.Entity.AcercaDe;
import com.portfolio.mgb.Repository.RAcercaDe;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SAcercaDe {
    @Autowired
    RAcercaDe  rAcercaDe;
    
    public List<AcercaDe> list(){
        return rAcercaDe.findAll();
    }
    
    public Optional<AcercaDe> getOne(int id){
        return rAcercaDe.findById(id);
    }
    
    public Optional<AcercaDe> getByProfecion(String profecion){
        return rAcercaDe.findByProfecion(profecion);
    }
    
    public void save(AcercaDe acercaDe){
        rAcercaDe.save(acercaDe);
    }
    
    public boolean existsInfo(){
        return rAcercaDe.findAll().isEmpty();
    }
    public void delete(int id){
        rAcercaDe.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rAcercaDe.existsById(id);
    }
    
    public boolean existsByProfecion(String profecion){
        return rAcercaDe.existsByProfecion(profecion);
    }
    
}
