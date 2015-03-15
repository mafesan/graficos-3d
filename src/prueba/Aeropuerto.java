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
     */

    /* Proximos pasos para la práctica:
     * Falta darle vida al aeropuerto, ejemplo:
     * bucle que itere y en cada iteracion pasen cosas, como
     * que los aviones avancen (cambien de posicion) y al llegar
     * a una en concreto aterricen, y la pista va diciendo si 
     * hay algun avion en ella.
     */
    
    public static float pos_y = -2.5f;
    
    public static void main() {
       
       Dibujable dibujables[] = new Dibujable[10];
       pos_y += 0.01;
       
       Fondo miPaisaje = new Fondo();
       dibujables[0] = miPaisaje;
       Pista pistaMain = new Pista();
       dibujables[1] = pistaMain;
       Pista pista2 = new Pista();
       Torre torreControl = new Torre();
       dibujables[2] = torreControl;
       Avion miBoeing1 = new Avion(0f, pos_y-1.5f, 0f);
       Avion miBoeing2 = new Avion(0.4f, pos_y-1.8f, 0f);
       Avion miBoeing3 = new Avion(-0.4f, pos_y-1.8f, 0f);
       Avion miBoeing4 = new Avion(0.8f, pos_y-2f, 0f);
       Avion miBoeing5 = new Avion(-0.8f, pos_y-2f, 0f);
       
       dibujables[3] = miBoeing1;
       dibujables[4] = miBoeing2;
       dibujables[5] = miBoeing3;
       dibujables[6] = miBoeing4;
       dibujables[7] = miBoeing5;
       
       //Dibujamos los elementos
       for(int dex = 0; dex <= 7; dex++){
           dibujables[dex].Draw();
       }
       
       //Interactuamos con ellos
       miPaisaje.AddElements();
       miPaisaje.WeatherNow();
       torreControl.Altura();
       torreControl.Connect();
       
       pistaMain.LongPista();
       pistaMain.EsPrincipal("Principal");
       
       
       
       /*
       pista2.Draw();
       pista2.EsPrincipal("Otra");
       
       miBoeing.TakeOff();
       miBoeing.PlaneSpeed();
       miBoeing.LandPlane();
        */
    }
    
}
