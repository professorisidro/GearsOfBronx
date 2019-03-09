package br.edu.ufabc.meuprimeirojogo.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.assets.loaders.ModelLoader.ModelParameters;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.IntAttribute;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial.MaterialType;
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
		Model mBanco   = loader.loadModel(Gdx.files.internal("cenario/banco.g3db"));
		Model mLixo    = loader.loadModel(Gdx.files.internal("cenario/lixo.g3db"));
		Model mLixeira = loader.loadModel(Gdx.files.internal("cenario/lixeira.g3db"));
		Model mIdle    = loader.loadModel(Gdx.files.internal("ryu/ryu_idle.g3db"));
		Model mPunch   = loader.loadModel(Gdx.files.internal("ryu/ryu_punch.g3db"));
		Model mDie     = loader.loadModel(Gdx.files.internal("ryu/ryu_die.g3db"));
		//objects.add(new GameObject(mCenario, false));
		
		GameObject die = new GameObject(mDie);
		//die.transform.translate(3, 0, 3);
		objects.add(die);
		System.out.println("adicionei DIE");
		for (Material m: die.materials) {
			m.remove(BlendingAttribute.Type);
		}
		GameObject idle = new GameObject(mIdle);
		idle.transform.translate(-3,0,3);
		objects.add(idle);
		for (Material m: idle.materials) {
			m.remove(BlendingAttribute.Type);
		}
		System.out.println("adicionei IDLE");
		GameObject punch = new GameObject(mPunch);
		punch.transform.translate(3,0,-3);
		for (Material m: punch.materials) {
			m.remove(BlendingAttribute.Type);
		}
		objects.add(punch);
		
		System.out.println("adicionei PUNCH");
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
		
	}
}
