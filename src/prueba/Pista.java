/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_TRIANGLE_STRIP;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex3f;

/**
 *
 * @author MiguelAngel
 */

class Pista extends Dibujable{
    int x, y;
    int longitud = 500;
    boolean principal = true;
    
    public void LongPista() {
        System.out.println("La pista mide: " + longitud + " metros.");
    }
    
    public void EsPrincipal(String tipo){
        if(tipo == "Principal"){
             System.out.println("Esta es la pista principal");
        }else{
             System.out.println("Esta es una pista secundaria");
        }
    }

    @Override
    public void Draw() {
        System.out.println("Dibujando pista...");
        glColor3f(0.1f, 0.1f, 0.1f);
        glBegin(GL_TRIANGLE_STRIP);
            glVertex3f(-0.4f, -0.8f, 0f);
            glVertex3f(0.4f, -0.8f, 0f);
            glVertex3f(-0.4f, 0.8f, 0f);
            glVertex3f(0.4f, 0.8f, 0f);
        glEnd();
        }
}
