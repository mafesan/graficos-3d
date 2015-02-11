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
class Pista {
    int longitud = 500;
    boolean principal = true;
    
    public void LongPista() {
        System.out.println("La pista mide: " + longitud);
    }
    
    public void EsPrincipal(){
        if(principal){
             System.out.println("Esta es la pista principal");
        }else{
             System.out.println("Esta es una pista secundaria");
        }
    }

    void Draw() {
       System.out.println("Dibujando pista...");
    }
}
