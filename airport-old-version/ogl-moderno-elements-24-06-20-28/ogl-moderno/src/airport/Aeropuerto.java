/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package airport;

import Utils.*;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.BufferUtils;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
/**
 *
 * @author MiguelAngel
 */

public class implements Drawable {

    /**
     */

    /* Proximos pasos para la práctica:
     * Falta darle vida al aeropuerto, ejemplo:
     * bucle que itere y en cada iteracion pasen cosas, como
     * que los aviones avancen (cambien de posicion) y al llegar
     * a una en concreto aterricen, y la pista va diciendo si 
     * hay algun avion en ella.
     */

    private ShaderProgram shaderProgram;
    private final OpenGLHelper openGLHelper = new OpenGLHelper("Airport", new FPCameraControllerA(-5, -5, -15));

    private int uniModel;
    private int uNMatrixAttribute;

    private final CubeModel cubeModel = new CubeModel();
    private final SphereModel sphereModel = new SphereModel();
    private final PlaneModel planeModel = new PlaneModel(5, 5);
    private final PlaneModel roadModel = new PlaneModel(5, 1);

    private int cubeVao, axiesVao, sphereVao, planeVao, roadVao;
    private int uKdAttribute;
    private int uKaAttribute;
    private int useTextures;
    private int uniTex1, uniTex2, uniTex3;
    
    private Texture fieldstoneTexture, stoneTexture, nicegrasstexture, roadTexture;
    
    
    public Aeropuerto(){
    	
    }
    
    public void drawFloor() {
        
        shaderProgram.setUniform(uniTex1, nicegrasstexture.getId() -1);
        glBindVertexArray(planeVao);
        glUniform3f(uKaAttribute, 1.0f, 1.0f, 1.0f);
        glUniform3f(uKdAttribute, 1.0f, 1.0f, 1.0f);
        glUniform1i(useTextures, 3);

        Matrix4f model = Matrix4f.scale(20.0f, 1.0f, 20.0f);
        model = Matrix4f.translate(10, 0, 0).multiply(model);
        glUniformMatrix4(uniModel, false, model.getBuffer());

        Matrix3f normalMatrix = model.multiply(openGLHelper.getViewMatrix()).toMatrix3f().invert();
        normalMatrix.transpose();
        glUniformMatrix3(uNMatrixAttribute, false, normalMatrix.getBuffer());

        glDrawElements(GL_TRIANGLES, planeModel.getIndicesLength(), GL_UNSIGNED_INT, 0);
    }
    
    public static void main(int shaderProgr, int uniModel) {
       
       Dibujable dibujables[] = new Dibujable[10];
       
       Fondo miPaisaje = new Fondo();
       //dibujables[0] = miPaisaje;
       //Pista pistaMain = new Pista();
       //dibujables[1] = pistaMain;
       //Pista pista2 = new Pista();
       //Torre torreControl = new Torre();
       //dibujables[2] = torreControl;
       Avion miBoeing1 = new Avion(0.4f, -0.8f, 0f);
       Suelo miSuelo = new Suelo();
       
       dibujables[0] = miBoeing1;
       dibujables[1] = miSuelo;
       miBoeing1.Draw(shaderProgr, uniModel);
       miSuelo.Draw(shaderProgr, uniModel);
       //Dibujamos los elementos
       //
       //for(int dex = 0; dex <= 7; dex++){
       //    dibujables[dex].Draw(int shaderProgram);
       //}
       
       //Interactuamos con ellos
       
       
       /*miPaisaje.AddElements();
       miPaisaje.WeatherNow();
       torreControl.Altura();
       torreControl.Connect();
       
       pistaMain.LongPista();
       pistaMain.EsPrincipal("Principal");
       */	       

    }

    
}
