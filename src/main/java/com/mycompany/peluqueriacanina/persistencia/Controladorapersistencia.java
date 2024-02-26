
package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Dueño;
import com.mycompany.peluqueriacanina.logica.Mascota;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controladorapersistencia {
    
        DueñoJpaController dueñojpa = new DueñoJpaController();
        MascotaJpaController mascotajpa= new MascotaJpaController();

    public void Guardar(Dueño dueño, Mascota masco) {

        //Creamos en la BD al dueño
        dueñojpa.create(dueño);
        
        //Creamos en la BD mascota
        mascotajpa.create(masco);
        
        
        
    }

    public List<Mascota> traerMascota() {
        return mascotajpa.findMascotaEntities();
    }

    public void borrarMascota(int num_cliente) {
            try
            {
                mascotajpa.destroy(num_cliente);
            } catch (NonexistentEntityException ex)
            {
                Logger.getLogger(Controladorapersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public Mascota traerMascota(int num_cliente) {
        return mascotajpa.findMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco) {
            try
            {
                mascotajpa.edit(masco);
            } catch (Exception ex)
            {
                Logger.getLogger(Controladorapersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public Dueño traerDueño(int id_dueño) {
        
        return  dueñojpa.findDueño(id_dueño);
    }

    public void modificardueño(Dueño dueño) {
            try
            {
                dueñojpa.edit(dueño);
            } catch (Exception ex)
            {
                Logger.getLogger(Controladorapersistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

 

  
    
}
