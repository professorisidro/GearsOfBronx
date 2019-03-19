package br.edu.ufabc.meuprimeirojogo.util;

import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.math.Vector3;

import br.edu.ufabc.meuprimeirojogo.core.GameObject;

public class ChasingCamera extends PerspectiveCamera {
	private GameObject objectToFollow;
	private Vector3 objectPosition;
	private float offsetZ = -5;
	private float offsetY = 1;

	public ChasingCamera(float fov, float width, float height, float offsetY, float offsetZ) {
		super(fov, width, height);
		this.offsetY = offsetY;
		this.offsetZ = offsetZ;
		objectPosition = new Vector3();
	}
	

	public float getOffsetZ() {
		return offsetZ;
	}


	public void setOffsetZ(float offsetZ) {
		this.offsetZ = offsetZ;
	}


	public float getOffsetY() {
		return offsetY;
	}


	public void setOffsetY(float offsetY) {
		this.offsetY = offsetY;
	}


	public void setObjectToFollow(GameObject obj) {
		this.objectToFollow = obj;
	}

	public void update() {
		if (objectToFollow != null) {

			objectToFollow.transform.getTranslation(objectPosition);
			float angulo = objectToFollow.getAngle();
			
			float newX = objectPosition.x + (float)(offsetZ*Math.sin(Math.toRadians(angulo)));
			float newY = objectPosition.y + offsetY;
			float newZ = objectPosition.z + (float)(offsetZ*Math.cos(Math.toRadians(angulo)));
			this.position.set(newX, newY, newZ);
			this.lookAt(objectPosition.x, newY, objectPosition.z);
		}
		super.update();
	}

}
