/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import static org.lwjgl.opengl.GL11.GL_TRIANGLE_STRIP;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex3f;

/**
 *
 * @author Miguel Angel
 */
class Fondo extends Dibujable {
    String elementos;
    String tipoClima = "Lluvioso";
   
    int num1 = 1;
    int num2 = 2; 
    @Override
    public void Draw(num1, num2) {
        System.out.println("Dibujando fondo...");
        glColor3f(0.0f, 0.8f, 0.0f);
        glBegin(GL_TRIANGLE_STRIP);
            glVertex3f(-1f, -1f, 0f);
            glVertex3f(1f, -1f, 0f);
            glVertex3f(-1f, 1f, 0f);
            glVertex3f(1f, 1f, 0f);
        glEnd();
    }
    
    public void AddElements() {
        elementos = "Cielo, sol, nubes, montañas";
        System.out.println("Añadiendo al fondo: " + elementos);
    }

    public void WeatherNow() {
        System.out.println("El clima ahora es: " + tipoClima);
    }
}
