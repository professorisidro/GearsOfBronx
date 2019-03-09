package br.edu.ufabc.meuprimeirojogo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import br.edu.ufabc.meuprimeirojogo.screen.GameScreen;
import br.edu.ufabc.meuprimeirojogo.screen.MyScreen;
import br.edu.ufabc.meuprimeirojogo.screen.StartScreen;

public class MeuJogo extends Game{

	private MyScreen currentScreen;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
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
