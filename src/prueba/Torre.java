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
class Torre extends Dibujable{
    int x, y, z;
    int height = 60;
    
    @Override
    public void Draw() {
       System.out.println("Dibujando torre de control...");
    }
    
    public void Connect() {
       System.out.println("Conectando con la torre de control...");
    }
    
    public void Altura() {
       System.out.println("La torre de control mide " + height + " metros.");
    }
}
