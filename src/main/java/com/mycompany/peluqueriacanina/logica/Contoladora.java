
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.Controladorapersistencia;
import java.util.List;


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

    public List<Mascota> traerMascotas() {
        return controlpersis.traerMascota();
        
        
    }

    public void borrarMascota(int num_cliente) {
        controlpersis.borrarMascota(num_cliente);
    }

    public Mascota traerMascotas(int num_cliente) {
        return controlpersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, 
            String color, String observaciones, String alergico, String atenEsp,
            String nombreDueño, String cellDueño) {
        
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAtencion_especial(atenEsp);
        masco.setAlergico(alergico);
        //Modifico mascota
        controlpersis.modificarMascota(masco);
        Dueño dueño = this.buscarDueño(masco.getUn_Dueño().getId_dueño());
        
        //Seteo los nuevos valores del dueño
        dueño.setCelDueño(cellDueño);
        dueño.setNombre(nombreDueño);
        //llamar al modificar dueño
        this.modificardueño(dueño);
    }

    private Dueño buscarDueño(int id_dueño) {
        return controlpersis.traerDueño(id_dueño);
    }

    private void modificardueño(Dueño dueño) {
        controlpersis.modificardueño(dueño);
    }


    
}
