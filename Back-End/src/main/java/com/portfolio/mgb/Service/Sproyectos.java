/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mgb.Service;

import com.portfolio.mgb.Entity.Proyectos;
import com.portfolio.mgb.Repository.RProyectos;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class Sproyectos {
    @Autowired
    RProyectos rProyectos;
    
    public List<Proyectos> list(){
        return rProyectos.findAll();
    }
    public Optional<Proyectos> getOne(int id){
        return rProyectos.findById(id);
    }
    public Optional<Proyectos> getByNombreP(String nombreP){
        return rProyectos.findByNombreP(nombreP);
    }
    public Optional<Proyectos> getByUrlP(String urlP){
        return rProyectos.findByUrlP(urlP);
    }
    public void save(Proyectos proyecto){
        rProyectos.save(proyecto);
    }
    public void delete(int id){
        rProyectos.deleteById(id);
    }
    public boolean existById(int id){
        return rProyectos.existsById(id);
    }
    public boolean existByNombreP(String nombreP){
        return rProyectos.existsByNombreP(nombreP);
    }
    public boolean existByUrlP(String urlP){
        return rProyectos.existsByUrlP(urlP);
    }
}
