package net.qial.galaxy.render;


import java.awt.Font;

import net.qial.galaxy.world.ObjLoc;
import net.qial.galaxy.world.Universe;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

public class SimpleView {
	private Universe uni;
	public SimpleView(Universe u) {
		this.uni = u;
	}
	
	private double scalar = 1.0;
	private int x = 400;
	private int y = 300;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 600;
	private static final int MOVE_SPEED = 60;
	
	private TrueTypeFont font;
	 
	public void init() {
		// load a default java font
		Font awtFont = new Font("Arial", Font.BOLD, 20);
		font = new TrueTypeFont(awtFont, false);
	}
	
	public void start() {
		
	    try {
		    Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT));
		    Display.create();
		} catch (LWJGLException e) {
		    e.printStackTrace();
		    System.exit(0);
		}
	 
		// init OpenGL
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
		init();
		
		long time = System.currentTimeMillis();
		int frames = 0;
		
		while (!Display.isCloseRequested()) {
		    // Clear the screen and depth buffer
		    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);	
			
		    // set the color of the quad (R,G,B,A)
		    GL11.glColor3f(0.5f,0.5f,1.0f);
		    	
		    // draw quad
//		    GL11.glBegin(GL11.GL_QUADS);
//		        GL11.glVertex2f(100,100);
//			GL11.glVertex2f(100+200,100);
//			GL11.glVertex2f(100+200,100+200);
//			GL11.glVertex2f(100,100+200);
//		    GL11.glEnd();
		    int objsDrawn = 0;
		    for(ObjLoc loc : uni.getSystems()) {
		    	if(isInDrawArea(loc)) {
		    		drawObject(loc);
		    		objsDrawn++;
		    	}
		    }
		    
		    font.drawString(100f, 50f, "THE LIGHTWEIGHT JAVA GAMES LIBRARY", Color.yellow);
		    
		    pollInput();
		    Display.update();
		    frames++;
		    if(System.currentTimeMillis() > time+1000) {
			    System.out.println(objsDrawn+", FPS "+frames);
			    time = System.currentTimeMillis();
			    frames = 0;
		    }
		    
		}
	 
		Display.destroy();
    }
	
	private boolean isInDrawArea(ObjLoc loc) {
		int lx = getObjX(loc);
		int ly = getObjY(loc);
		if(lx < 0 || lx > WIDTH)
			return false;
		if(ly < 0 || ly > HEIGHT)
			return false;
		return true;
	}
	
	private int getObjY(ObjLoc loc) {
		// get x and y
		int ly = loc.getY();
		// determine distance from center
		int dy = y-ly;
		// multiply by scalar
		int fy = (int)(dy*scalar);
		ly = HEIGHT/2 + fy;
		return ly;
	}
	
	private int getObjX(ObjLoc loc) {
		// get x and y
		int lx = loc.getX();
		// determine distance from center
		int dx = x-lx;
		// multiply by scalar
		int fx = (int)(dx*scalar);
		lx = WIDTH/2 + fx;
		return lx;
	}
	
	private void drawObject(ObjLoc loc) {
		int lx = getObjX(loc);
		int ly = getObjY(loc);
		
		GL11.glBegin(GL11.GL_QUADS);
    	GL11.glVertex2f(lx-2, ly-2);
    	GL11.glVertex2f(lx+2, ly-2);
    	GL11.glVertex2f(lx+2, ly+2);
    	GL11.glVertex2f(lx-2, ly+2);
    	GL11.glEnd();
	}
	
	
	
	public void pollInput() {
		
        if (Mouse.isButtonDown(0)) {
		    int x = Mouse.getX();
		    int y = Mouse.getY();
				
		    System.out.println("MOUSE DOWN @ X: " + x + " Y: " + y);
		}
        
        
			
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
		    //System.out.println("SPACE KEY IS DOWN");
		}
			
		while (Keyboard.next()) {
		    if (Keyboard.getEventKeyState()) {
		        if (Keyboard.getEventKey() == Keyboard.KEY_W) {
				    moveUp();
				}
		        if (Keyboard.getEventKey() == Keyboard.KEY_A) {
				    moveLeft();
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_S) {
				    moveDown();
					//System.out.println("S Key Pressed");
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_D) {
				    moveRight();
					//System.out.println("D Key Pressed");
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_X) {
				    zoomIn();
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_Z) {
				    zoomOut();
				}
		    } else {
		        if (Keyboard.getEventKey() == Keyboard.KEY_W) {
		        	//System.out.println("A Key Released");
		        }
		        if (Keyboard.getEventKey() == Keyboard.KEY_A) {
		        	//System.out.println("A Key Released");
		        }
		    	if (Keyboard.getEventKey() == Keyboard.KEY_S) {
				    //System.out.println("S Key Released");
				}
				if (Keyboard.getEventKey() == Keyboard.KEY_D) {
				    //System.out.println("D Key Released");
				}
		    }
		}
    }
	
	private void moveUp() {
		y -= (int)(MOVE_SPEED/scalar);
	}
	
	private void moveLeft() {
		x += (int)(MOVE_SPEED/scalar);
	}
	
	private void moveRight() {
		x -= (int)(MOVE_SPEED/scalar);
	}
	
	private void moveDown() {
		y += (int)(MOVE_SPEED/scalar);
	}
	
	private void zoomIn() {
		scalar *= 0.8;
	}
	
	private void zoomOut() {
		scalar *= 1.25;
	}
	
	public static void main(String[] args) {
		Universe u = new Universe();
		u.generateSystems(800, 600, 2000);
		SimpleView sv = new SimpleView(u);
		sv.start();
	}
}
