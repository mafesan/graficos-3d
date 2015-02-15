/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package prueba;

/**
 *
 * @author MiguelAngel
 */

public class Aeropuerto {

    /**
     * @param args the command line arguments
     */

    /* Proximos pasos para la práctica:
     * Falta darle vida al aeropuerto, ejemplo:
     * bucle que itere y en cada iteracion pasen cosas, como
     * que los aviones avancen (cambien de posicion) y al llegar
     * a una en concreto aterricen, y la pista va diciendo si 
     * hay algun avion en ella.
     */
    public static void main(String[] args) {
       Fondo miPaisaje = new Fondo();
       Pista pistaMain = new Pista();
       Pista pista2 = new Pista();
       Torre torreControl = new Torre();
       Avion miBoeing = new Avion();
       
       //Dibujamos los elementos
       miPaisaje.Draw();
       torreControl.Draw();
       pistaMain.Draw();
       
       miBoeing.Draw();
       
       //Interactuamos con ellos
       miPaisaje.AddElements();
       miPaisaje.WeatherNow();
       torreControl.Altura();
       torreControl.Connect();
       
       pistaMain.LongPista();
       pistaMain.EsPrincipal("Principal");
       
       pista2.Draw();
       pista2.EsPrincipal("Otra");
       
       miBoeing.TakeOff();
       miBoeing.PlaneSpeed();
       miBoeing.LandPlane();

    }
    
}
