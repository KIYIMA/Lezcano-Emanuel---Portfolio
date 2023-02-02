
package com.portfolio.mgb.Dto;

import javax.validation.constraints.NotBlank;


public class dtoAcercaDe {
    @NotBlank
    private String profecion;
    @NotBlank
    private String descripcion;

    public dtoAcercaDe() {
    }

    public dtoAcercaDe(String profecion, String descripcion) {
        this.profecion = profecion;
        this.descripcion = descripcion;
    }

    public String getProfecion() {
        return profecion;
    }

    public void setProfecion(String profecion) {
        this.profecion = profecion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
