/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airport;

/**
 *
 * @author MiguelAngel
 */
public abstract class Dibujable {
    int x, y, z;
    
    public abstract void draw();
    public abstract void prepareBuffers();
}
