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

public class Simulador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Pista pistaMain = new Pista();
       Avion miBoeing = new Avion();
       
       pistaMain.Draw();
       pistaMain.LongPista();
       pistaMain.EsPrincipal();
       
       miBoeing.Draw();
       miBoeing.TakeOff();
       miBoeing.PlaneSpeed();
       miBoeing.LandPlane();

    }
    
}
