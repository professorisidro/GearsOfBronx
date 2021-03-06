package br.edu.ufabc.meuprimeirojogo;

import javax.print.DocFlavor.INPUT_STREAM;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

import br.edu.ufabc.meuprimeirojogo.screen.GameScreen;
import br.edu.ufabc.meuprimeirojogo.screen.MyScreen;
import br.edu.ufabc.meuprimeirojogo.screen.StartScreen;

public class MeuJogo extends Game implements InputProcessor {

	private MyScreen currentScreen;
	public static AssetManager assetManager;
	public static ModelBuilder modelBuider;
	public static boolean DEBUG = false;

	@Override
	public void create() {
		// TODO Auto-generated method stub
		modelBuider = new ModelBuilder();
		assetManager = new AssetManager();
		Gdx.input.setInputProcessor(this);

		assetManager.load("cenario/banco.g3db", Model.class);
		assetManager.load("cenario/lixo.g3db", Model.class);
		assetManager.load("cenario/lixeira.g3db", Model.class);
		assetManager.load("cenario/cenario.g3db", Model.class);
		assetManager.load("cenario/poste.g3db", Model.class);
		assetManager.load("ryu/ryu_idle.g3db", Model.class);
		assetManager.load("ryu/ryu_punch.g3db", Model.class);
		assetManager.load("ryu/ryu_die.g3db", Model.class);
		currentScreen = new StartScreen("START");
		setScreen(currentScreen);

	}

	public void render() {
		currentScreen.render(Gdx.graphics.getDeltaTime());
		if (currentScreen.isDone()) {
			// aqui eu cuido da transição das telas
			if (currentScreen.getId().equals("START")) {
				currentScreen = new GameScreen("GAME");
			} else {
				currentScreen = new StartScreen("START");
			}

		}
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		switch (keycode) {
		case Input.Keys.UP:
		    Commands.set[Commands.UP] = true;
//		    System.out.println(Commands.str());
		    return true;
		case Input.Keys.DOWN:
			Commands.set[Commands.DOWN] = true;
//			System.out.println(Commands.str());
		    return true;
		case Input.Keys.LEFT:
			Commands.set[Commands.LEFT] = true;
//			System.out.println(Commands.str());
		    return true;
		case Input.Keys.RIGHT:			
			Commands.set[Commands.RIGHT] = true;
//		    System.out.println(Commands.str());
		    return true;
		case Input.Keys.SPACE:
			Commands.set[Commands.SHOT] = true;
//			System.out.println(Commands.str());
		    return true;
		case Input.Keys.D:	
			Commands.set[Commands.DEBUG] = true;
//			System.out.println(Commands.str());
		    return true;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		switch (keycode) {
		case Input.Keys.UP:
			
		    Commands.set[Commands.UP] = false;
//		    System.out.println(Commands.str());
		    return true;
		case Input.Keys.DOWN:
			Commands.set[Commands.DOWN] = false;
//			System.out.println(Commands.str());
		    return true;
		case Input.Keys.LEFT:
			Commands.set[Commands.LEFT] = false;
//			System.out.println(Commands.str());
		    return true;
		case Input.Keys.RIGHT:
			Commands.set[Commands.RIGHT] = false;
//			System.out.println(Commands.str());
		    return true;
		case Input.Keys.SPACE:
			Commands.set[Commands.SHOT] = false;
//			System.out.println(Commands.str());
		    return true;
		case Input.Keys.D:
			Commands.set[Commands.DEBUG] = false;
//			System.out.println(Commands.str());
		    return true;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
