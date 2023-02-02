
package com.portfolio.mgb.Dto;

import javax.validation.constraints.NotBlank;


public class dtoContacto {
    @NotBlank
    private String email;
    @NotBlank
    private String asunto;
    @NotBlank
    private String cuerpo;

    public dtoContacto() {
    }

    public dtoContacto(String email, String asunto, String cuerpo) {
        this.email = email;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    
    
}
