package br.edu.ufabc.meuprimeirojogo.core;

import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import br.edu.ufabc.meuprimeirojogo.Commands;
import br.edu.ufabc.meuprimeirojogo.MeuJogo;
import br.edu.ufabc.meuprimeirojogo.model.AbstractModel;
import br.edu.ufabc.meuprimeirojogo.model.Chao;
import br.edu.ufabc.meuprimeirojogo.model.ObjetoColidivel;
import br.edu.ufabc.meuprimeirojogo.model.Poste;
import br.edu.ufabc.meuprimeirojogo.model.Robot;

public class GameAction {

	protected Array<AbstractModel> objects;
	protected Robot robot;
	protected String colidiu;

	public GameAction() {
		objects = new Array<AbstractModel>();
		// vou carregar os modelos aqui (inicialmente)
//		

		objects.add(new Chao());
		int mode = 0;

		// para fins de debug
		GameObject cenario = objects.get(0).getGameObject();
		Vector3 position = new Vector3();
		ObjetoColidivel object;
		for (Node n : cenario.nodes) {
			
			position = n.globalTransform.getTranslation(position);
			if (n.id.contains("poste")) {
				Poste poste = new Poste(mode);
				mode = (mode + 1) % 3;

				poste.getGameObject().transform.setToTranslation(position);
				poste.getGameObject().updateBoundingBox();
				poste.updateLight(position);
				objects.add(poste);
			}

			else if (n.id.contains("lixo")) {
				
				object = new ObjetoColidivel((Model)MeuJogo.assetManager.get("cenario/lixo.g3db"));
				object.getGameObject().transform.setToTranslation(position);
				object.getGameObject().updateBoundingBox();
				objects.add(object);
			} else if (n.id.contains("lixeira")) {
				object = new ObjetoColidivel((Model)MeuJogo.assetManager.get("cenario/lixeira.g3db"));
				object.getGameObject().transform.setToTranslation(position);
				object.getGameObject().updateBoundingBox();
				objects.add(object);
				
			} else if (n.id.contains("banco")) {
				object = new ObjetoColidivel((Model)MeuJogo.assetManager.get("cenario/banco.g3db"));
				object.getGameObject().transform.setToTranslation(position);
				object.getGameObject().updateBoundingBox();
				objects.add(object);
			}
		}

//		
		robot = new Robot();
		objects.add(robot);
		for (AbstractModel obj : objects) {
			for (Material mat : obj.getGameObject().materials) {
				mat.remove(ColorAttribute.Emissive);
			}
		}

	}

	public void update(float delta) {
		for (AbstractModel o : objects) {
			o.update(delta);
		}

		if (Commands.noCommand()) {
			robot.noAction();
		}
		if (Commands.set[Commands.UP]) {
			robot.step(delta);
		}
		if (Commands.set[Commands.LEFT]) {
			robot.rotateLeft(delta);
		}
		if (Commands.set[Commands.RIGHT]) {
			robot.rotateRight(delta);
		}
		if (Commands.set[Commands.DOWN]) {
			robot.stepBack(delta);
		}
		if (Commands.set[Commands.SHOT]) {
			robot.shoot();
		}
		

		colidiu = "Nao colide nada";
		for (AbstractModel m : objects) {

			if (m instanceof Poste || m instanceof ObjetoColidivel) {
				// calculo de distancia tosco
				if (robot.collidesWith(m)) {
					robot.stepBack(delta);
				}
//				//if (lixo.getGameObject().getBoundingBox().intersects(m.getGameObject().getBoundingBox())) {
//					//System.out.println("");
//					colidiu = "Colisao";
//				}
			}
		}
	}
}
