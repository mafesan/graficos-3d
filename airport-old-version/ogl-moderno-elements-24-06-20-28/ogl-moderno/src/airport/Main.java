/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

import Utils.Drawable;
import Utils.Matrix4f;
import Utils.FPCameraController;
import Utils.OpenGLHelper;
import Utils.ShaderProgram;

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
 * @author Miguel Angel Fernandez
 */
public class Main implements Drawable {
    
    // Valor inicial de variables
	private GLFWErrorCallback errorCallback;
    private GLFWKeyCallback keyCallback;
    private GLFWCursorPosCallback cpCallback;

    private final OpenGLHelper openGLHelper = new OpenGLHelper("Main Aeropuerto", new FPCameraController(-5, -5, -15));
    private int uniModel;
    private int uNMatrixAttribute;
    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;
    public static final int FLOAT_SIZE = 4;
    
    private long window;
    private ShaderProgram shaderProgram;
    private int uniView;
    
    
    private Dibujable dibujables[] = new Dibujable[10];
    
    private FPCameraController camera = new FPCameraController(-5, -5, -15);
    private float deltaTime = 0.0f; //length of frame
    private double lastFrame; // when the last frame was
    
    private float movementSpeed = 5.0f; //move 10 units per second
    private double lastX = 400, lastY = 300;
    
    public void run() {
        openGLHelper.initGL("VS_ADS_Texture.vs", "FS_ADS_Texture4.fs");
        openGLHelper.run(this);
    }
    
    private void initGL() {
        // Setup an error callback. The default implementation
        // will print the error message in System.err.
    	
    	dibujables[1] = new Avion(0.4f, -0.8f, 0f);
    	dibujables[0] = new Suelo();
    	
        glfwSetErrorCallback(errorCallback = errorCallbackPrint(System.err));

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if (glfwInit() != GL_TRUE) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // Configure our window
        glfwDefaultWindowHints(); // optional, the current window hints are already the default
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE); // the window will stay hidden after creation
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE); // the window will be resizable

        // Create the window
        window = glfwCreateWindow(WIDTH, HEIGHT, "Simulator by mghfdez", NULL, NULL);
        if (window == NULL) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        glfwSetKeyCallback(window, keyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
            	if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
                    glfwSetWindowShouldClose(window, GL_TRUE); // We will detect this in our rendering loop
                    return;
                }
               
                //when passing in the distance to move
                //we times the movementSpeed with dt this is a time scale
                //so if its a slow frame u move more then a fast frame
                //so on a slow computer you move just as fast as on a fast computer
                if (key == GLFW_KEY_W)//move forward
                {
                    camera.walkForward(movementSpeed*deltaTime);
                }
                if (key == GLFW_KEY_S)//move backwards
                {
                    camera.walkBackwards(movementSpeed*deltaTime);
                }
                if (key == GLFW_KEY_A)//strafe left
                {
                    camera.strafeLeft(movementSpeed*deltaTime);
                }
                if (key == GLFW_KEY_D)//strafe right
                {
                    camera.strafeRight(movementSpeed*deltaTime);
                }
            }
        });
        
        glfwSetCursorPosCallback(window, cpCallback = new GLFWCursorPosCallback() {
            private boolean firstMouse = true;
            
			@Override
			public void invoke(long window, double xpos, double ypos) {
				if(firstMouse)
			                    {
			                        lastX = xpos;
			                        lastY = ypos;
			                        firstMouse = false;
			                    }
			
			                    float xoffset = (float)(xpos - lastX);
			                    float yoffset = (float)(ypos - lastY); 
			
			                    lastX = xpos;
			                    lastY = ypos;
			
			                    camera.ProcessMouseMovement(xoffset, yoffset);
			}
			});

        // Get the resolution of the primary monitor
        ByteBuffer vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        // Center our window
        glfwSetWindowPos(
                window,
                (GLFWvidmode.width(vidmode) - WIDTH) / 2,
                (GLFWvidmode.height(vidmode) - HEIGHT) / 2
        );

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);
        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);
        
        GLContext.createFromCurrent();

        // Set the clear color
        glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
        
        glEnable(GL_DEPTH_TEST);
        
        // Compilar shaders
        int vertexShader = glCreateShader(GL_VERTEX_SHADER);
        glShaderSource(vertexShader, VertexShaderSrc);
        glCompileShader(vertexShader);
        int status = glGetShaderi(vertexShader, GL_COMPILE_STATUS);
        if (status != GL_TRUE) {
        	throw new RuntimeException(glGetShaderInfoLog(vertexShader));
        }
        
        int fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
        glShaderSource(fragmentShader, FragmentShaderSrc);
        glCompileShader(fragmentShader);
        status = glGetShaderi(fragmentShader, GL_COMPILE_STATUS);
        if (status != GL_TRUE) {
            throw new RuntimeException(glGetShaderInfoLog(vertexShader));
        }

        shaderProgram = glCreateProgram();
        glAttachShader(shaderProgram, vertexShader);
        glAttachShader(shaderProgram, fragmentShader);
        glLinkProgram(shaderProgram);
        glUseProgram(shaderProgram);
    }

    private void loop() {
    
        //OpenGL es una maquina de estados
    	/// Create a FloatBuffer of vertices
        /// Do not forget to do vertices.flip()! This is important, because passing the buffer without 
        // flipping will crash your JVM because of a EXCEPTION_ACCESS_VIOLATION.
    	Aeropuerto aeropuerto = new Aeropuerto();
    	dibujables[0].Prepare(shaderProgram, uniModel);
        dibujables[1].Prepare(shaderProgram, uniModel);
        
        uniModel = glGetUniformLocation(shaderProgram, "model");
        
        int uniProjection = glGetUniformLocation(shaderProgram, "projection");
        float ratio = (float)WIDTH / (float)HEIGHT;
        Matrix4f projection = Matrix4f.perspective(60, ratio, 0.1f, 100.0f );
        glUniformMatrix4(uniProjection, false, projection.getBuffer());
        
        uniView = glGetUniformLocation(shaderProgram, "view");
        // Run the rendering loop until the user has attempted to close
        // the window or has pressed the ESCAPE key.
        
        
  	    while (glfwWindowShouldClose(window) == GL_FALSE) {
	        
	        double currentFrame = glfwGetTime();
	        deltaTime = (float)(currentFrame - lastFrame);
	        lastFrame = currentFrame;
	        
	        // Poll for window events. The key callback above will only be
	        // invoked during this call.
	        glfwPollEvents();
	        
	        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
	
	        /* update camera position */
	        Matrix4f view = camera.lookThrough();
	        glUniformMatrix4(uniView, false, view.getBuffer());
	        
	        /* Render models */
	        dibujables[0].Draw(shaderProgram, uniModel);
	        dibujables[1].Draw(shaderProgram, uniModel);
	        
	        /* Swap buffers and poll Events */
	        glfwSwapBuffers(window); // swap the color buffers  
	    }
	}
    public static void main(String[] args) {
            new Main().run();
        }

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	 
}