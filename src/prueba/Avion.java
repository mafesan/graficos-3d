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
public class Avion {
    public int max_speed;
    public int num_people;
    public boolean tourist;
    public boolean landed;
    
    public static void TakeOff(Boolean landed) {
        if(landed == true){
            System.out.println("Ya podemos despegar");
        }else{
            System.out.println("El avion ya estaba en el aire");
        }
    }
    
    public static void LandPlane(String resultado) {
        resultado = "Aterrizaje OK";
        System.out.println(resultado);
    }
}
