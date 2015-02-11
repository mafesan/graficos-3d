/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

/**
 *
 * @author Miguel Angel
 */
class Fondo extends Dibujable {
    String elementos;
    String tipoClima = "Lluvioso";
   
    @Override
    public void Draw() {
        System.out.println("Dibujando fondo...");
    }
    
    public void AddElements() {
        elementos = "Cielo, sol, nubes, montañas";
        System.out.println("Añadiendo al fondo: " + elementos);
    }

    public void WeatherNow() {
        System.out.println("El clima ahora es: " + tipoClima);
    }
}
