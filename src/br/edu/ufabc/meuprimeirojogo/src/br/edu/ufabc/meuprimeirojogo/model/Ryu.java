package br.edu.ufabc.meuprimeirojogo.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.loaders.ModelLoader;
import com.badlogic.gdx.assets.loaders.ModelLoader.ModelParameters;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.loader.G3dModelLoader;
import com.badlogic.gdx.utils.UBJsonReader;

import br.edu.ufabc.meuprimeirojogo.MeuJogo;
import br.edu.ufabc.meuprimeirojogo.core.GameObject;

public class Ryu {
	private int estado=0;
	public static final int IDLE=0;
	public static final int PUNCH=1;
	public static final int DIE=2;
	private GameObject[] estados;
	
	public Ryu() {
		estados = new GameObject[3];
		estado = IDLE;
//		ModelLoader<ModelParameters> loader;
//		loader = new G3dModelLoader(new UBJsonReader());
		
		Model mIdle  = MeuJogo.assetManager.get("ryu/ryu_idle.g3db");
		Model mPunch = MeuJogo.assetManager.get("ryu/ryu_punch.g3db");
		Model mDie   = MeuJogo.assetManager.get("ryu/ryu_die.g3db");
		
		estados[IDLE]  = new GameObject(mIdle, true, true, true, 1);
		estados[PUNCH] = new GameObject(mPunch, true, true, true, 1);
		estados[DIE]   = new GameObject(mDie, true, true, false, 0.3f);
		for (GameObject o: estados) {
			for (Material m: o.materials) {
				m.remove(BlendingAttribute.Type);
			}
		}
	}
	public void idle() {
		estado = IDLE;
	}
	public void punch() {
		estado = PUNCH;
	}
	public void die() {
		estado = DIE;
	}
	
	public void update(float delta) {
		estados[estado].update(delta);
		if (estado == DIE && estados[estado].isAnimiationFinished()) {
			estados[DIE].setVisible(false);
		}
		else if (estado == PUNCH && estados[estado].isAnimiationFinished()) {
			estados[estado].resetAnimation();
			estado = IDLE;
		}
	}
	public GameObject getCurrent() {
		return estados[estado];
	}
	

}
