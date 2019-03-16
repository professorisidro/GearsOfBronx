package br.edu.ufabc.meuprimeirojogo.model;

import br.edu.ufabc.meuprimeirojogo.core.GameObject;

public abstract class AbstractModel {
	public boolean collidable;
	public boolean moveable;
	
	public AbstractModel(boolean collidable, boolean moveable) {
		this.collidable = collidable;
		this.moveable   = moveable;
	}
	
	public abstract void update(float delta);
	public abstract GameObject getGameObject();
	

}
