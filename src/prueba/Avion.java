/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex3f;
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
        glColor3f(0f, 0f, 1f);
        glBegin(GL_TRIANGLES);
                glVertex3f(-0.2f, -0.1f, 0f);
                glVertex3f(0.2f, -0.1f, 0f);
                glVertex3f(0f, 0.2f, 0f);
        glEnd();
        
    }
    
}
