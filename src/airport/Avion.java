/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

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
public class Avion extends Dibujable{
    float x, y, z;
    int speed = 600;
    int num_people;

    public Avion(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
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
        glColor3f(0.4f, 0.4f, 0.4f);
        glBegin(GL_TRIANGLES); //Morro del avión
            glVertex3f(-0.04f+this.x, 0.08f+this.y, 0f+this.z);
            glVertex3f(0.04f+this.x, 0.08f+this.y, 0f+this.z);
            glVertex3f(0f+this.x, 0.16f+this.y, 0f+this.z);
        glEnd();
        glColor3f(0.7f, 0.7f, 0.7f);
        glBegin(GL_TRIANGLE_STRIP); //Cuerpo del avion
            glVertex3f(-0.04f+this.x, -0.12f+this.y, 0f+this.z);
            glVertex3f(0.04f+this.x, -0.12f+this.y, 0f+this.z);
            glVertex3f(-0.04f+this.x, 0.08f+this.y, 0f+this.z);
            glVertex3f(0.04f+this.x, 0.08f+this.y, 0f+this.z);
        glEnd();
        
        glColor3f(0f, 0.35f, 1f);
        glBegin(GL_TRIANGLES); //Ala izquierda
            glVertex3f(-0.16f+this.x, -0.04f+this.y, 0f+this.z);
            glVertex3f(-0.04f+this.x, 0f+this.y, 0f+this.z);
            glVertex3f(-0.04f+this.x, 0.08f+this.y, 0f+this.z);
        glEnd();
        glBegin(GL_TRIANGLES); //Ala derecha
            glVertex3f(0.04f+this.x, 0f+this.y, 0f+this.z);
            glVertex3f(0.16f+this.x, -0.04f+this.y, 0f+this.z);
            glVertex3f(0.04f+this.x, 0.08f+this.y, 0f+this.z);
        glEnd();
        glColor3f(1f, 0f, 0f);
        glBegin(GL_TRIANGLES); //Cola - parte 1
            glVertex3f(-0.02f+this.x, -0.16f+this.y, 0f+this.z);
            glVertex3f(-0.04f+this.x, -0.12f+this.y, 0f+this.z);
            glVertex3f(0f+this.x, -0.12f+this.y, 0f+this.z);
        glEnd();
        glBegin(GL_TRIANGLES); //Cola - parte 2
            glVertex3f(0.02f+this.x, -0.16f+this.y, 0f+this.z);
            glVertex3f(0f+this.x, -0.12f+this.y, 0f+this.z);
            glVertex3f(0.04f+this.x, -0.12f+this.y, 0f+this.z);
        glEnd();
    }
    
}

/*Segun la tarjeta con el código que ha subido Agustinm
--> si no funciona: 
donde pone #version 150 -->borrar
poner 130 \n
*/