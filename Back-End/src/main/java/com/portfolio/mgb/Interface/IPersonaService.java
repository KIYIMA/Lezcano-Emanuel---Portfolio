
package com.portfolio.mgb.Interface;

import com.portfolio.mgb.Entity.Persona;
import java.util.List;



public interface IPersonaService {
    
    //Traer una lista de personas
    public List<Persona> getPersona();
    
    //Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);
    
    //Eliminar un usuario, buscamos por id
    public void deletePersona(Long id);
    
    //Buscamos una persona por id
    public Persona findPersona(Long id);
}
