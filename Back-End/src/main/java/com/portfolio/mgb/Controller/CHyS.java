/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mgb.Controller;

import com.portfolio.mgb.Dto.dtoHyS;
import com.portfolio.mgb.Entity.HyS;
import com.portfolio.mgb.Security.Controller.Mensaje;
import com.portfolio.mgb.Service.SHyS;
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
@RequestMapping("/hys")

//Local
@CrossOrigin//(origins = "https://newpro-32aab.web.app")
public class CHyS {
    @Autowired
    SHyS sHyS;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<HyS>> list(){
        List<HyS> list = sHyS.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<HyS> getById(@PathVariable("id") int id){
        if(!sHyS.existById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        HyS hyS = sHyS.getOne(id).get();
        return new ResponseEntity(hyS, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sHyS.existById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sHyS.delete(id);
        return new ResponseEntity(new Mensaje("Tecnología eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoHyS dtohyS){
        if(StringUtils.isBlank(dtohyS.getNombre())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sHyS.existByNombre(dtohyS.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        HyS hyS = new HyS(dtohyS.getNombre(), dtohyS.getPorcentaje());
        sHyS.save(hyS);
        return new ResponseEntity(new Mensaje("Proyecto agregado!!"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoHyS dtohyS){
        if(!sHyS.existById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sHyS.existByNombre(dtohyS.getNombre()) && sHyS.getByNombre(dtohyS.getNombre()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe!!"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtohyS.getNombre())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio!!"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(dtohyS.getPorcentaje())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio!!"), HttpStatus.BAD_REQUEST);
        }
        
        HyS hyS = sHyS.getOne(id).get();
        
        hyS.setNombre(dtohyS.getNombre());  
        hyS.setPorcentaje(dtohyS.getPorcentaje());
        
        sHyS.save(hyS);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}
