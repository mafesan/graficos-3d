/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import Utils.Matrix4f;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.Sys;
import static org.lwjgl.glfw.Callbacks.errorCallbackPrint;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.glfw.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;

import org.lwjgl.opengl.GLContext;
import static org.lwjgl.system.MemoryUtil.NULL;

/**
 *
 * @author MiguelAngel
 */
public class Avion extends Dibujable{
    float x, y, z;
    int speed = 600;
    int num_people;
    private float count = 0;
    private float count2 = 0;
    private float count3 = 0;
    private int vbo_v;
    private int vbo_c;

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

    float[] vertices = new float[]
            {
                  1.0f,  1.0f,  1.0f ,         // Top Right Of The Quad (Front)
                 -1.0f,  1.0f,  1.0f ,         // Top Left Of The Quad (Front)
                 -1.0f, -1.0f,  1.0f ,         // Bottom Left Of The Quad (Front)
                  1.0f, -1.0f,  1.0f ,         // Bottom Right Of The Quad (Front)
                  
                  1.0f, 1.0f, -1.0f ,          // Top Right Of The Quad (Top)
                 -1.0f, 1.0f, -1.0f ,          // Top Left Of The Quad (Top)
                 -1.0f, 1.0f,  1.0f ,          // Bottom Left Of The Quad (Top)
                  1.0f, 1.0f,  1.0f ,          // Bottom Right Of The Quad (Top)
            
                  1.0f, -1.0f,  1.0f ,         // Top Right Of The Quad (Bottom)
                 -1.0f, -1.0f,  1.0f ,         // Top Left Of The Quad (Bottom)
                 -1.0f, -1.0f, -1.0f ,         // Bottom Left Of The Quad (Bottom)
                  1.0f, -1.0f, -1.0f ,         // Bottom Right Of The Quad (Bottom)
            
                  1.0f, -1.0f, -1.0f ,         // Bottom Left Of The Quad (Back)
                 -1.0f, -1.0f, -1.0f ,         // Bottom Right Of The Quad (Back)
                 -1.0f,  1.0f, -1.0f ,         // Top Right Of The Quad (Back)
                  1.0f,  1.0f, -1.0f ,         // Top Left Of The Quad (Back)
            
                 -1.0f,  1.0f,  1.0f ,         // Top Right Of The Quad (Left)
                 -1.0f,  1.0f, -1.0f ,         // Top Left Of The Quad (Left)
                 -1.0f, -1.0f, -1.0f ,         // Bottom Left Of The Quad (Left)
                 -1.0f, -1.0f,  1.0f ,         // Bottom Right Of The Quad (Left)

                  1.0f,  1.0f, -1.0f ,         // Top Right Of The Quad (Right)
                  1.0f,  1.0f,  1.0f ,         // Top Left Of The Quad (Right)
                  1.0f, -1.0f,  1.0f ,         // Bottom Left Of The Quad (Right)
                  1.0f, -1.0f, -1.0f           // Bottom Right Of The Quad (Right)
            };
    
    //Definimos los colores de los vertices
    float[] colors = new float[]
            {
                  1.0f,  1.0f,  1.0f ,         // Top Right Of The Quad (Front)
                  0.0f,  0.0f,  0.0f ,         // Top Left Of The Quad (Front)
                  0.0f,  0.0f,  1.0f ,         // Bottom Left Of The Quad (Front)
                  0.0f,  0.0f,  1.0f ,         // Bottom Right Of The Quad (Front)
                  
                  1.0f, 1.0f,  1.0f ,          // Top Right Of The Quad (Top)
                  0.0f, 0.0f,  0.0f ,          // Top Left Of The Quad (Top)
                  0.0f, 0.0f,  1.0f ,          // Bottom Left Of The Quad (Top)
                  0.0f, 0.0f,  1.0f ,          // Bottom Right Of The Quad (Top)
                  
                  1.0f,  1.0f,  1.0f ,         // Top Right Of The Quad (Bottom)
                  0.0f,  0.0f,  0.0f ,         // Top Left Of The Quad (Bottom)
                  0.0f,  0.0f,  1.0f ,         // Bottom Left Of The Quad (Bottom)
                  0.0f,  0.0f,  1.0f ,         // Bottom Right Of The Quad (Bottom)
            
                  1.0f,  1.0f,  1.0f ,         // Bottom Left Of The Quad (Back)
                  0.0f,  0.0f,  0.0f ,         // Bottom Right Of The Quad (Back)
                  0.0f,  0.0f,  1.0f ,         // Top Right Of The Quad (Back)
                  0.0f,  0.0f,  1.0f ,         // Top Left Of The Quad (Back)
            
                  1.0f,  1.0f,  1.0f ,         // Top Right Of The Quad (Left)
                  0.0f,  0.0f,  0.0f ,         // Top Left Of The Quad (Left)
                  0.0f,  0.0f,  1.0f ,         // Bottom Left Of The Quad (Left)
                  0.0f,  0.0f,  1.0f ,         // Bottom Right Of The Quad (Left)

                  1.0f,  1.0f,  1.0f ,         // Top Right Of The Quad (Right)
                  0.0f,  0.0f,  0.0f ,         // Top Left Of The Quad (Right)
                  0.0f,  0.0f,  1.0f ,         // Bottom Left Of The Quad (Right)
                  0.0f,  0.0f,  1.0f           // Bottom Right Of The Quad (Right)
            };
    @Override
    public void Draw(int shaderProg, int unimodel) {
        //System.out.println("Dibujando avión...");
    	count += 0.01f;
    	count2 += 0.0023f;
    	count3 += 0.02f;
        // Definimos los vertices
        FloatBuffer verticesBuffer = BufferUtils.createFloatBuffer(vertices.length);
        verticesBuffer.put(vertices).flip();

        vbo_v = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo_v);
        glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);
 
        int posAttrib = glGetAttribLocation(shaderProg, "aVertexPosition");
        glEnableVertexAttribArray(posAttrib);
        glBindBuffer(GL_ARRAY_BUFFER, vbo_v);
        
        glVertexAttribPointer(posAttrib, 3, GL_FLOAT, false, 0, 0);      
        
        FloatBuffer colorsBuffer = BufferUtils.createFloatBuffer(colors.length);
        colorsBuffer.put(colors).flip();
 
        vbo_c = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo_c);
        glBufferData(GL_ARRAY_BUFFER, colorsBuffer, GL_STATIC_DRAW);

        int vertexColorAttribute = glGetAttribLocation(shaderProg, "aVertexColor");
        glEnableVertexAttribArray(vertexColorAttribute);
        glBindBuffer(GL_ARRAY_BUFFER, vbo_c);
        glVertexAttribPointer(vertexColorAttribute, 3, GL_FLOAT, false, 0, 0);
        
        float posX = -1 + (float)Math.cos(count);
        float posY = -1 + (float)Math.sin(count2);
        float posZ = -1 + (float)Math.sin(count3);
        Matrix4f model = Matrix4f.rotate(200, 0.5f, 1f, 1f);
        model = Matrix4f.scale(0.4f, 0.4f, 0.4f).multiply(model);
        model = Matrix4f.translate(posX, posY, -7).multiply(model);
        glUniformMatrix4(unimodel, false, model.getBuffer());
        glDrawArrays(GL_QUADS, 0, 4*6);

    }
    
}


/*Segun la tarjeta con el código que ha subido Agustinm
--> si no funciona: 
donde pone #version 150 -->borrar
poner 130 \n
*/