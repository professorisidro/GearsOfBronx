package br.edu.ufabc.meuprimeirojogo.model;

import com.badlogic.gdx.graphics.g3d.Model;
import br.edu.ufabc.meuprimeirojogo.MeuJogo;
import br.edu.ufabc.meuprimeirojogo.core.GameObject;

public class Poste extends AbstractModel {
	private GameObject modelPoste;
	public Poste() {
		super(false,false);
		modelPoste = new GameObject((Model)MeuJogo.assetManager.get("cenario/poste.g3db"));
		
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		modelPoste.update(delta);
		
	}

	@Override
	public GameObject getGameObject() {
		// TODO Auto-generated method stub
		return modelPoste;
	}

}
