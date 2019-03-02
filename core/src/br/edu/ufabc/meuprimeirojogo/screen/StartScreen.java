package br.edu.ufabc.meuprimeirojogo.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;

public class StartScreen extends MyScreen{

	private Texture     texture;
	private SpriteBatch spriteBatch;
	private Matrix4     viewMatrix;
	private Matrix4     tranMatrix;
	
	public StartScreen(String id) {
		super(id);	
		texture     = new Texture("start.png");
		spriteBatch = new SpriteBatch();
		viewMatrix  = new Matrix4();
		tranMatrix  = new Matrix4();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		texture.dispose();
		spriteBatch.dispose();
		
	}

	@Override
	public void update(float delta) {
		
		if (Gdx.input.justTouched()) {
			setDone(true);  // terminei o que tinha pra fazer
		}
	}

	@Override
	public void draw(float delta) {
		// define que vou usar bits de cores para limpar a tela
		Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
		// define que vou usar a cor preta (0,0,0,0)
		Gdx.gl20.glClearColor(0, 0, 0, 0);
		viewMatrix.setToOrtho2D(0, 0, 800, 600); // defino a "configuração da resolução"
		spriteBatch.setProjectionMatrix(viewMatrix); // buffer irá seguir essa configuração
		spriteBatch.setTransformMatrix(tranMatrix); // toda vez q redimensionar a tela, armazene as distorçoes na matriz
		
		spriteBatch.begin();
		spriteBatch.draw(texture, 0,0,800,600, 0,0,800,600, 
				                  false, false);
		spriteBatch.end();
		
	}

}






