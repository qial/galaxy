package net.qial.galaxy.render;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import net.qial.galaxy.world.Universe3;

public class FourView {
	
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	private Universe3 uni;
	
	public FourView(Universe3 uni) {
		this.uni = uni;
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
		
		long time = System.currentTimeMillis();
		int frames = 0;
		
		while(!Display.isCloseRequested()) {
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			
			GL11.glColor3f(0.5f, 0.5f, 1.0f);
			
			render();
		}
	}
	
	public void render() {
		
	}
	
	private void renderView() {
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Universe3 uni = new Universe3();
		uni.generateSystems(1000, 2000);
	}

}
