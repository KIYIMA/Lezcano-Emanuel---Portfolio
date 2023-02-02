
package com.portfolio.mgb.Controller;

import com.portfolio.mgb.Dto.dtoAcercaDe;
import com.portfolio.mgb.Entity.AcercaDe;
import com.portfolio.mgb.Security.Controller.Mensaje;
import com.portfolio.mgb.Service.SAcercaDe;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acercaDe")

//Local
@CrossOrigin//(origins = "https://newpro-32aab.web.app")

public class CAcercaDe {
    @Autowired
    SAcercaDe sAcercaDe;
    
    @GetMapping("/lista")
    public ResponseEntity<List<AcercaDe>> list(){
        List<AcercaDe> list = sAcercaDe.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<AcercaDe> getById(@PathVariable("id") int id){
        if(!sAcercaDe.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        AcercaDe acercaDe = sAcercaDe.getOne(id).get();
        return new ResponseEntity(acercaDe, HttpStatus.OK);
    }
    @GetMapping("/hayinfo")
    public ResponseEntity<AcercaDe> getHayinfo(){
        if(!sAcercaDe.existsInfo()){
            return new ResponseEntity(new Mensaje("No se pudo corroborar si hay informacion"), HttpStatus.BAD_REQUEST);
        }
        boolean acercaDe = sAcercaDe.existsInfo();
        return new ResponseEntity(acercaDe, HttpStatus.OK);
    }
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sAcercaDe.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sAcercaDe.delete(id);
        return new ResponseEntity(new Mensaje("AcercaDe eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcercaDe dtoacercade){
        if(StringUtils.isBlank(dtoacercade.getProfecion())){
            return new ResponseEntity(new Mensaje("Campo Profecion obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sAcercaDe.existsByProfecion(dtoacercade.getProfecion())){
            return new ResponseEntity(new Mensaje("Esa profecion ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        AcercaDe acercaDe = new AcercaDe(dtoacercade.getProfecion(), dtoacercade.getDescripcion());
        sAcercaDe.save(acercaDe);
        return new ResponseEntity(new Mensaje("Informacion agregada al AcercaDe !!"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcercaDe dtoacercade){
        if(!sAcercaDe.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sAcercaDe.existsByProfecion(dtoacercade.getProfecion()) && sAcercaDe.getByProfecion(dtoacercade.getProfecion()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Profecion existente!!"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoacercade.getProfecion())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio!!"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtoacercade.getDescripcion())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio!!"), HttpStatus.BAD_REQUEST);
        }
        
        AcercaDe acercaDe = sAcercaDe.getOne(id).get();
        
        acercaDe.setProfecion(dtoacercade.getProfecion());
        acercaDe.setDescripcion(dtoacercade.getDescripcion());
        
        
        sAcercaDe.save(acercaDe);
        return new ResponseEntity(new Mensaje("AcercaDe actualizado"), HttpStatus.OK);
    }
}
