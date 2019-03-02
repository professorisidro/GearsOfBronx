package br.edu.ufabc.meuprimeirojogo.core;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;

public class GameObject extends ModelInstance{
	private boolean visible;
	
	public GameObject(Model model) {
		super(model);
		visible = true;
	}
	public GameObject(Model model, boolean visible) {
		super(model);
		this.visible = visible;
	}
	
	public void update(float delta) {
		
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

}
