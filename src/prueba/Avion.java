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
public class Avion extends Dibujable{
    int x, y, z;
    int speed = 600;
    int num_people;
    
    public void TakeOff() {
        System.out.println("Avion despegando...");
    }
    
    public void LandPlane() {
        System.out.println("Aterrizaje OK");
    }
    
    public void PlaneSpeed() {
        System.out.println("La velocidad del avion es: " + speed + " km/h.");
    }

    @Override
    public void Draw() {
        System.out.println("Dibujando avión...");
    }
    
}
