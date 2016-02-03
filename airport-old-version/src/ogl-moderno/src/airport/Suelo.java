package airport;

import Utils.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

public class Suelo extends Dibujable {
	
    private ShaderProgram shaderProgram;
    private final OpenGLHelper openGLHelper = new OpenGLHelper("Tutorial Mix", new FPCameraController(-5, -5, -15));
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

    private Texture fieldstoneTexture, stoneTextures, nicegrasstexture, roadTexture;
    
	public Suelo(){
		
	}

	private void prepareModels() {
        // --------------------- AXIES MODEL  -------------------------------//
        shaderProgram = openGLHelper.getShaderProgram();
        int posAttrib = shaderProgram.getAttributeLocation("aVertexPosition");
        int vertexNormalAttribute = shaderProgram.getAttributeLocation("aVertexNormal");
        int texCoordsAttribute = shaderProgram.getAttributeLocation("aVertexTexCoord");

        axiesVao = glGenVertexArrays();
        glBindVertexArray(axiesVao);

        int vbo_v = cubeModel.createVerticesBuffer();
        glBindBuffer(GL_ARRAY_BUFFER, vbo_v);
        glEnableVertexAttribArray(posAttrib);
        glVertexAttribPointer(posAttrib, 3, GL_FLOAT, false, 0, 0);

        int vbo_n = cubeModel.createNormalsBuffer();
        glBindBuffer(GL_ARRAY_BUFFER, vbo_n);
        glEnableVertexAttribArray(vertexNormalAttribute);
        glVertexAttribPointer(vertexNormalAttribute, 3, GL_FLOAT, false, 0, 0);

        int ebo = cubeModel.createIndicesBuffer();
        glBindVertexArray(0);

        uniModel = shaderProgram.getUniformLocation("model");
        uNMatrixAttribute = shaderProgram.getUniformLocation("uNMatrix");
        useTextures = shaderProgram.getUniformLocation("useTextures");

        // ----------------------- CUBE MODEL -----------------------------//
        cubeVao = glGenVertexArrays();
        glBindVertexArray(cubeVao);

        glBindBuffer(GL_ARRAY_BUFFER, vbo_v);
        glEnableVertexAttribArray(posAttrib);
        glVertexAttribPointer(posAttrib, 3, GL_FLOAT, false, 0, 0);

        glBindBuffer(GL_ARRAY_BUFFER, vbo_n);
        glEnableVertexAttribArray(vertexNormalAttribute);
        glVertexAttribPointer(vertexNormalAttribute, 3, GL_FLOAT, false, 0, 0);

        int vbo_t = cubeModel.createTextCoordsBuffer();
        glBindBuffer(GL_ARRAY_BUFFER, vbo_t);
        glEnableVertexAttribArray(texCoordsAttribute);
        glVertexAttribPointer(texCoordsAttribute, 2, GL_FLOAT, false, 0, 0);

        ebo = cubeModel.createIndicesBuffer();

        glActiveTexture(GL_TEXTURE0);
        nicegrasstexture = Texture.loadTexture("nicegrass.jpg");
        uniTex1 = shaderProgram.getUniformLocation("Texture1");
        shaderProgram.setUniform(uniTex1, 0);

        glActiveTexture(GL_TEXTURE1);
        Texture texture = Texture.loadTexture("baserock.jpg");
        uniTex2 = shaderProgram.getUniformLocation("Texture2");
        shaderProgram.setUniform(uniTex2, 1);

        glActiveTexture(GL_TEXTURE2);
        texture = Texture.loadTexture("darkrockalpha.png");
        uniTex3 = shaderProgram.getUniformLocation("Texture3");
        shaderProgram.setUniform(uniTex3, 2);

        glBindVertexArray(0);
        
        glActiveTexture(GL_TEXTURE3);
        fieldstoneTexture = Texture.loadTexture("fieldstone.jpg");
        
        glActiveTexture(GL_TEXTURE4);
        //stoneTexture = Texture.loadTexture("stone-128px.jpg");
        
        glActiveTexture(GL_TEXTURE5);
        roadTexture = Texture.loadTexture("stone-256px.jpg");
        
        // ----------------------- SPHERE MODEL -----------------------------//
        sphereVao = glGenVertexArrays();
        glBindVertexArray(sphereVao);

        vbo_v = sphereModel.createVerticesBuffer();
        glBindBuffer(GL_ARRAY_BUFFER, vbo_v);
        glEnableVertexAttribArray(posAttrib);
        glVertexAttribPointer(posAttrib, 3, GL_FLOAT, false, 0, 0);

        vbo_n = sphereModel.createNormalsBuffer();
        glBindBuffer(GL_ARRAY_BUFFER, vbo_n);
        glEnableVertexAttribArray(vertexNormalAttribute);
        glVertexAttribPointer(vertexNormalAttribute, 3, GL_FLOAT, false, 0, 0);

        ebo = sphereModel.createIndicesBuffer();
        glBindVertexArray(0);
        
        // ----------------------- PLANE MODEL -----------------------------//
        planeVao = glGenVertexArrays();
        glBindVertexArray(planeVao);

        vbo_v = planeModel.createVerticesBuffer();
        glBindBuffer(GL_ARRAY_BUFFER, vbo_v);
        glEnableVertexAttribArray(posAttrib);
        glVertexAttribPointer(posAttrib, 3, GL_FLOAT, false, 0, 0);

        vbo_n = planeModel.createNormalsBuffer();
        glBindBuffer(GL_ARRAY_BUFFER, vbo_n);
        glEnableVertexAttribArray(vertexNormalAttribute);
        glVertexAttribPointer(vertexNormalAttribute, 3, GL_FLOAT, false, 0, 0);

        vbo_t = planeModel.createTextCoordsBuffer();
        glBindBuffer(GL_ARRAY_BUFFER, vbo_t);
        glEnableVertexAttribArray(texCoordsAttribute);
        glVertexAttribPointer(texCoordsAttribute, 2, GL_FLOAT, false, 0, 0);

        ebo = planeModel.createIndicesBuffer();
        glBindVertexArray(0);

        
    }
	
	@Override
	public void Draw(int shaderProgr, int uniModel) {
		// TODO Auto-generated method stub
		
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
	
}
