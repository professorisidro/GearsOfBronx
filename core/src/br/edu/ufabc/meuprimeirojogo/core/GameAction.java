package br.edu.ufabc.meuprimeirojogo.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.assets.loaders.ModelLoader.ModelParameters;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.UBJsonReader;

public class GameAction {
	
	protected Array<GameObject> objects;
	
	public GameAction() {
		objects = new Array<GameObject>();
		// vou carregar os modelos aqui (inicialmente)
		ModelLoader<ModelParameters> loader;
		loader = new G3dModelLoader(new UBJsonReader());
		Model mCenario = loader.loadModel(Gdx.files.internal("cenario/cenario.g3db"));
		Model mPoste   = loader.loadModel(Gdx.files.internal("cenario/poste.g3db"));
		objects.add(new GameObject(mCenario));
		
		
		// para fins de debug
		GameObject cenario = objects.first();
	    Vector3 position = new Vector3();
		for (Node n: cenario.nodes) {
			position = n.globalTransform.getTranslation(position);
//			System.out.println(n.id + " - " + position);
			if (n.id.contains("poste")) {
				GameObject poste = new GameObject(mPoste);
				poste.transform.setToTranslation(position);
				objects.add(poste);
				System.out.println("add poste");
				
			}
		}
	}

	public void update(float delta) {
		
	}
}
