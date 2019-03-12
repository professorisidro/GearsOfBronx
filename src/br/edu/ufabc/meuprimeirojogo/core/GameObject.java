package br.edu.ufabc.meuprimeirojogo.core;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController.AnimationDesc;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController.AnimationListener;

public class GameObject extends ModelInstance{
	private boolean visible;
	private boolean animated;
	private boolean animationFinished;
	private AnimationController controller;
	
	public GameObject(Model model) {
		super(model);
		visible = true;  
		animationFinished = false;
	}
	public GameObject(Model model, boolean visible) {
		this(model);
		this.visible = visible;
	}
	public GameObject(Model model, boolean visible, boolean animated, boolean looped, float loopSpeed) {
		this(model, visible);
		this.animated = animated;
		controller = new AnimationController(this);
		if (animated) {
			controller.setAnimation(this.animations.first().id, (looped)? -1: 1, loopSpeed, 
					new AnimationListener() {

						@Override
						public void onEnd(AnimationDesc animation) {
							// TODO Auto-generated method stub
							animationFinished = true;
						}

						@Override
						public void onLoop(AnimationDesc animation) {
							// TODO Auto-generated method stub
							animationFinished = true;
						}
				
			});
		}
	}
	
	public void update(float delta) {
		if (animated) {
		   controller.update(delta);
	   
		}
		
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public boolean isAnimiationFinished() {
		return this.animationFinished;
	}
	public void resetAnimation() {
		animationFinished = false;		
	}

}
