/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import static org.lwjgl.opengl.GL11.GL_TRIANGLE_STRIP;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex3f;

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
       glColor3f(0.5f, 0.4f, 0.6f);
        glBegin(GL_TRIANGLE_STRIP);
            glVertex3f(-0.95f, 0.5f, 0f);
            glVertex3f(-0.6f, 0.5f, 0f);
            glVertex3f(-0.95f, 0.8f, 0f);
            glVertex3f(-0.6f, 0.8f, 0f);
        glEnd();
    }
    
    public void Connect() {
       System.out.println("Conectando con la torre de control...");
    }
    
    public void Altura() {
       System.out.println("La torre de control mide " + height + " metros.");
    }
}
