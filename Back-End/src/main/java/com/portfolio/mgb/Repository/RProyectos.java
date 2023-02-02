/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.mgb.Repository;

import com.portfolio.mgb.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyectos  extends JpaRepository<Proyectos, Integer>{
    
    public Optional<Proyectos> findByNombreP(String nombreP);
    public Optional<Proyectos> findByUrlP(String urlP);
    
    public boolean existsByNombreP(String nombreE);
    public boolean existsByUrlP(String urlE);
}
