package net.qial.galaxy.render;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import net.qial.galaxy.engine.Dim;
import net.qial.galaxy.world.Obj3Loc;
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
			Display.update();
		    frames++;
		    if(System.currentTimeMillis() > time+1000) {
			    System.out.println("FPS "+frames);
			    time = System.currentTimeMillis();
			    frames = 0;
		    }
		}

		Display.destroy();
	}
	
	public void render() {
		renderView(Dim.X, Dim.Y,0,0);
		renderView(Dim.X, Dim.Z,WIDTH/2,HEIGHT/2);
		renderView(Dim.Y, Dim.Z,0,HEIGHT/2);
	}
	
	// x and y are for 0,0 corner, effectively, all drawing is positive from there
	private void renderView(Dim d1, Dim d2, int x, int y) {
		// in most cases, x is either 0 or WIDTH/2, and y is either 0 or HEIGHT/2
		// okay, so vx = Width/4 + x.
		int vx = WIDTH/4 + x; // this is the center x of our view
		int vy = HEIGHT/4 + y; // this is the center y of our view
		
		// wait do I need those? lol
		
		// being display loop
		for(Obj3Loc obj : uni.getSystems()) {
			int ox = obj.get(d1)/2;
			int oy = obj.get(d2)/2;
			
			if(ox > WIDTH/2 || oy > HEIGHT/2) {
				continue;
			}
			
			// now divide by size/2 to scale to the view
			int fx = ox + x;
			int fy = oy + y;
			
			
			// draw
			GL11.glBegin(GL11.GL_QUADS);
	    	GL11.glVertex2f(fx-1, fy-1);
	    	GL11.glVertex2f(fx+1, fy-1);
	    	GL11.glVertex2f(fx+1, fy+1);
	    	GL11.glVertex2f(fx-1, fy+1);
	    	GL11.glEnd();
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Universe3 uni = new Universe3();
		uni.generateSystems(1000, 2000);
		FourView fv = new FourView(uni);
		fv.start();
	}

}
