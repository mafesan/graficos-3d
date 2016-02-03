
package airport;

import airport.NewAvion;
import airport.NewAeropuerto;
import airport.Pista;
import airport.Suelo;
import airport.Torre;
import Utils.*;

import Utils.FPCameraController;

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
 * @author Mghfdez
 */

public class NewAeropuerto implements Drawable {
	
	private ShaderProgram shaderProgram;
    private final OpenGLHelper openGLHelper = new OpenGLHelper("Airport", new FPCameraController(-40, -5, -20));
    

    private Torre torreControl;
    private Torre torreControl2;
    private Pista pistaMain;
    private NewAvion miBoeing;
    private NewAvion miBoeing2;
    private Suelo miSuelo;

    
    public void run() {
    	
    	openGLHelper.initGL("VS_Texture.vs", "FS_Texture.fs");
        initObjects();
        prepareBuffers();
        openGLHelper.run(this);
    }

    private void initObjects() {
	  shaderProgram = openGLHelper.getShaderProgram();
	  
	  miSuelo = new Suelo();
      miSuelo.setTexture("terrain.jpg");
      
      pistaMain = new Pista();
      pistaMain.setTexture("RoadTexture.jpg");
      
      torreControl = new Torre();
      torreControl.setTexture("glass.jpg");
      
      torreControl2 = new Torre();
      torreControl2.setTexture("metal.jpg");
      
	  miBoeing = new NewAvion();
	  miBoeing.setTexture("stone-128px.jpg");
	  
	  miBoeing2 = new NewAvion();
	  miBoeing2.setTexture("stone-128px.jpg");
          
	}

    private void prepareBuffers() {
        shaderProgram = openGLHelper.getShaderProgram();              
        
    }

    @Override
    public void draw()
    {
        /* Render a model */
        drawSomeModel();
    }
    
    float angle;
    private static final float angularVelocity = 30.f;
 
    private void drawSomeModel() {
    	
    	miSuelo.setRotation(0.0f, 0.0f, 1f, 0);
    	miSuelo.setPosition(10,0,0);
    	miSuelo.setScale(50.0f, 1.0f, 50.0f);
    	
    	miSuelo.draw(openGLHelper);
    	
    	pistaMain.setRotation(0.0f, 0.0f, 1f, 0);
    	pistaMain.setPosition(10, 0.1f, 0.0f);
    	pistaMain.setScale(50.0f, 1.0f, 6.0f);
    	
    	pistaMain.draw(openGLHelper);
    	
    	torreControl.setRotation(0.0f, 0.0f, 1f, 0);
    	torreControl.setPosition(25, 0.0f, -35.0f);
    	torreControl.setScale(10.0f, 5.0f, 3.0f);
    	
    	torreControl.draw(openGLHelper); 
    	
    	torreControl2.setRotation(0.0f, 0.0f, 1f, 0);
    	torreControl2.setPosition(25, 0.0f, -35.0f);
    	torreControl2.setScale(10.0f, 5.0f, 3.0f);
    	
    	torreControl2.draw(openGLHelper); 
    	
		miBoeing.setRotation(270.0f, 0.0f, 1f, 0);
		miBoeing.setPosition(-50, 1.0f, 0.0f, 0.5f);
		miBoeing.setScale(0.0018f, 0.0018f, 0.0018f);
  	
		miBoeing.draw(openGLHelper); 
       
		miBoeing2.setRotation(270f, 0.0f, 1f, 0);
		miBoeing2.setPosition(-50, 8.0f, -14.0f, 0.7f);
		miBoeing2.setScale(0.0015f, 0.0015f, 0.0015f);
  	
		miBoeing2.draw(openGLHelper);
    }

    public static void main(String[] args) {
        new NewAeropuerto().run();
    }

}
