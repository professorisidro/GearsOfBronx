package br.edu.ufabc.meuprimeirojogo.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;

public class Renderer {
	
	private GameAction        gameAction;
	private Environment       environment;
	private ModelBatch        modelBatch;
	private PerspectiveCamera camera;
	private CameraInputController input;
	
	public Renderer(GameAction action) {
		this.gameAction = action;
		modelBatch  = new ModelBatch();
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.6f,0.6f,0.6f,0));
		camera = new PerspectiveCamera(67.0f, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.near = 0.1f;
		camera.far  = 300f;
		camera.position.set(0, 5, 10);
		camera.lookAt(0,5,0);
	    camera.update();
	    input = new CameraInputController(camera);
	    Gdx.input.setInputProcessor(input);
	}

	public void draw(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		Gdx.gl.glClearColor(0, 0, 0, 0);
		modelBatch.begin(camera);
		for (GameObject o: gameAction.objects) {
			if (o.isVisible()) modelBatch.render(o, environment);
		}
		modelBatch.end();
		camera.update();
	}
}
