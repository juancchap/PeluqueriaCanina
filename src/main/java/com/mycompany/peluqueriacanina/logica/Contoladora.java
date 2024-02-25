
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.Controladorapersistencia;


public class Contoladora {
    
        Controladorapersistencia controlpersis = new Controladorapersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, 
            String alergico, String atenEsp, String nombreDueño, String cellDueño) {
        
        //Creamos al dueño y asignamos sus valores
        Dueño dueño = new Dueño();
        dueño.setNombre(nombreDueño);
        dueño.setCelDueño(cellDueño);
        
        
        //Creamos la mascota y asignamos sus valores
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);
        masco.setObservaciones(observaciones);
        masco.setUn_Dueño(dueño);
        
        controlpersis.Guardar(dueño,masco);
        
    }
    
}
