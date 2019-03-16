package br.edu.ufabc.meuprimeirojogo.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import br.edu.ufabc.meuprimeirojogo.MeuJogo;
import br.edu.ufabc.meuprimeirojogo.model.AbstractModel;
import br.edu.ufabc.meuprimeirojogo.model.Chao;
import br.edu.ufabc.meuprimeirojogo.model.Poste;

public class GameAction {
	
	protected Array<AbstractModel> objects;
	
	
	public GameAction() {
		objects = new Array<AbstractModel>();
		// vou carregar os modelos aqui (inicialmente)
//		
		
		
		objects.add(new Chao());
		
		
		
		// para fins de debug
		GameObject cenario = objects.first().getGameObject();
	    Vector3 position = new Vector3();
		for (Node n: cenario.nodes) {
			System.out.println(n.id);
			position = n.globalTransform.getTranslation(position);
			GameObject object;
			if (n.id.contains("poste")) {
				Poste poste = new Poste();
				poste.getGameObject().transform.setToTranslation(position);
				objects.add(poste);
			}
		}
//			else if (n.id.contains("lixo")) {
//				object = new GameObject(mLixo, false);
//				object.transform.setToTranslation(position);
//				objects.add(object);
//			}
//			else if (n.id.contains("lixeira")) {
//				object = new GameObject(mLixeira, false);
//				object.transform.setToTranslation(position);
//				objects.add(object);
//			}
//			else if (n.id.contains("banco")) {
//				object = new GameObject(mBanco, false);
//				object.transform.setToTranslation(position);
//				objects.add(object);
//			}
//		}
//		
		for (AbstractModel obj: objects) {
			for (Material mat: obj.getGameObject().materials) {
					mat.remove(ColorAttribute.Emissive);
			}
		}
		
		
	}

	public void update(float delta) {
		for (AbstractModel o: objects) {
			o.update(delta);
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
			MeuJogo.DEBUG = !MeuJogo.DEBUG;
		}
		
		
		
	}
}
