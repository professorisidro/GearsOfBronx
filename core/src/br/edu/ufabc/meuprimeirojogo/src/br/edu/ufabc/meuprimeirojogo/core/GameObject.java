package br.edu.ufabc.meuprimeirojogo.core;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController.AnimationDesc;
import com.badlogic.gdx.graphics.g3d.utils.AnimationController.AnimationListener;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

import br.edu.ufabc.meuprimeirojogo.MeuJogo;

public class GameObject extends ModelInstance{
	private boolean visible;
	private boolean animated;
	private boolean animationFinished;
	private AnimationController controller;
	private BoundingBox         boundingBox;
	/* for debug */
	private ModelInstance       boxInstance;
	private Vector3             position;
	
	public GameObject(Model model) {
		super(model);
		visible = true;  
		animationFinished = false;
		boundingBox = new BoundingBox();
		calculateBoundingBox(boundingBox);
		//System.out.println("Bounding Box = "+boundingBox);
		// for debug reasons
		Vector3 boxMax = new Vector3();
		Vector3 boxMin = new Vector3();
		boundingBox.getMax(boxMax);
		boundingBox.getMin(boxMin);
		boxInstance = new ModelInstance(MeuJogo.modelBuider.createBox(
				(Math.abs(boxMax.x)+Math.abs(boxMin.x)), 
				(Math.abs(boxMax.y)+Math.abs(boxMin.y)), 
				(Math.abs(boxMax.z)+Math.abs(boxMin.z)), 
                new Material(ColorAttribute.createDiffuse(Color.LIGHT_GRAY)),
                Usage.Position | Usage.Normal));
		BlendingAttribute bl = new BlendingAttribute(GL20.GL_SRC_ALPHA 
				                                   | GL20.GL_ONE_MINUS_SRC_ALPHA);
		bl.opacity = 0.6f;
		boxInstance.materials.get(0).set(bl);
		position = new Vector3();
				
		
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
		// for debug reasons
		this.transform.getTranslation(position);
	
//		Vector3 boxMax = new Vector3();
//		Vector3 boxMin = new Vector3();
//		boundingBox.getMax(boxMax);
//		boundingBox.getMin(boxMin);
		boundingBox.max.add(position);
		boundingBox.min.add(position);
		position.y = (boundingBox.getHeight()/2);
		boxInstance.transform.setToTranslation(position);
		
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
	
	public BoundingBox getBoundingBox() {
		return boundingBox;
	}
	
	public ModelInstance getBoxInstance() {
		return boxInstance;
	}
	
	

}
