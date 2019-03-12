package br.edu.ufabc.meuprimeirojogo.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.assets.loaders.ModelLoader.ModelParameters;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.UBJsonReader;

import br.edu.ufabc.meuprimeirojogo.MeuJogo;
import br.edu.ufabc.meuprimeirojogo.model.Ryu;

public class GameAction {
	
	protected Array<GameObject> objects;
	protected Ryu ryu;
	
	public GameAction() {
		objects = new Array<GameObject>();
		// vou carregar os modelos aqui (inicialmente)
//		ModelLoader<ModelParameters> loader;
//		loader = new G3dModelLoader(new UBJsonReader());
		Model mCenario = MeuJogo.assetManager.get("cenario/cenario.g3db");
		Model mPoste   = MeuJogo.assetManager.get("cenario/poste.g3db");
		Model mBanco   = MeuJogo.assetManager.get("cenario/banco.g3db");
		Model mLixo    = MeuJogo.assetManager.get("cenario/lixo.g3db");
		Model mLixeira = MeuJogo.assetManager.get("cenario/lixeira.g3db");
		Model mIdle    = MeuJogo.assetManager.get("ryu/ryu_idle.g3db");
		Model mPunch   = MeuJogo.assetManager.get("ryu/ryu_punch.g3db");
		Model mDie     = MeuJogo.assetManager.get("ryu/ryu_die.g3db");
		//objects.add(new GameObject(mCenario, false));
		
		ryu = new Ryu();
		
		// para fins de debug
//		GameObject cenario = objects.first();
//	    Vector3 position = new Vector3();
//		for (Node n: cenario.nodes) {
//			System.out.println(n.id);
//			position = n.globalTransform.getTranslation(position);
//			GameObject object;
//			if (n.id.contains("poste")) {
//				object = new GameObject(mPoste, false);
//				object.transform.setToTranslation(position);
//				objects.add(object);
//			}
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
//		for (GameObject o: objects) {
//			for (Material mat: o.materials) {
//					mat.remove(ColorAttribute.Emissive);
//			}
//		}
		
		
	}

	public void update(float delta) {
		for (GameObject o: objects) {
			o.update(delta);
		}
		ryu.update(delta);
		if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
			System.out.println("Porrada");
			ryu.punch();
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
			System.out.println("Morreu");
			ryu.die();
		}
		if (Gdx.input.isKeyJustPressed(Input.Keys.I)) {
			System.out.println("voltou");
			ryu.idle();
		}
		
	}
}
