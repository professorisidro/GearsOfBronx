package br.edu.ufabc.meuprimeirojogo.model;

import com.badlogic.gdx.graphics.g3d.Model;

import br.edu.ufabc.meuprimeirojogo.Commands;
import br.edu.ufabc.meuprimeirojogo.MeuJogo;
import br.edu.ufabc.meuprimeirojogo.core.GameObject;

public class LixoAndante extends AbstractModel {

	private GameObject lixo;
	
	public int movimento;
	public static final int PARADO  = 0;
	public static final int FRENTE  = 1;
	public static final int TRAS    =-1;
	public static final int DIREITA = 2;
	public static final int ESQUERDA=-2;
	public float  step = 2;
	
	public LixoAndante() {
		super(true, true);
		lixo = new GameObject((Model)MeuJogo.assetManager.get("cenario/lixo.g3db"));
		
	}
	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		if (Commands.set[Commands.UP]) {
			lixo.transform.translate(0,0,step*delta);
		}
		if (Commands.set[Commands.DOWN]) {
			lixo.transform.translate(0,0,-step*delta);
		}
		if (Commands.set[Commands.LEFT]) {
			lixo.transform.translate(step*delta,0,0);
		}
		if (Commands.set[Commands.RIGHT]) {
			lixo.transform.translate(-step*delta, 0, 0);
		}
		lixo.update(delta);
		lixo.updateBoundingBox();
		
	}

	@Override
	public GameObject getGameObject() {
		// TODO Auto-generated method stub
		return lixo;
	}

}
