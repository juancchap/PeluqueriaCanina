
package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Dueño;
import com.mycompany.peluqueriacanina.logica.Mascota;


public class Controladorapersistencia {
    
        DueñoJpaController dueñojpa = new DueñoJpaController();
        MascotaJpaController mascotajpa= new MascotaJpaController();

    public void Guardar(Dueño dueño, Mascota masco) {

        //Creamos en la BD al dueño
        dueñojpa.create(dueño);
        
        //Creamos en la BD mascota
        mascotajpa.create(masco);
        
        
        
    }

  
    
}
