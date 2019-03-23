package br.edu.ufabc.meuprimeirojogo.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;

public class Utilities {
	public static final int GAME_WIDTH  = 800;
	public static final int GAME_HEIGHT = 600;
	
	public static Vector3 convertCoordinates(float x, float y) {
		Vector3 pos = new Vector3();
		pos.x = ((x / (float)Gdx.graphics.getWidth())*GAME_WIDTH);
		pos.y = GAME_HEIGHT - ((y / (float)Gdx.graphics.getHeight())*GAME_HEIGHT);
		
		return pos;
	}

}
