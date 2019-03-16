package br.edu.ufabc.meuprimeirojogo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

import br.edu.ufabc.meuprimeirojogo.screen.GameScreen;
import br.edu.ufabc.meuprimeirojogo.screen.MyScreen;
import br.edu.ufabc.meuprimeirojogo.screen.StartScreen;

public class MeuJogo extends Game{

	private MyScreen currentScreen;
	public static AssetManager assetManager;
	public static ModelBuilder modelBuider;
	public static boolean      DEBUG = false;
	@Override
	public void create() {
		// TODO Auto-generated method stub
		modelBuider  = new ModelBuilder();
		assetManager = new AssetManager();
		
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
			}
			else {
				currentScreen = new StartScreen("START");
			}
			
		}
	}
	
}
