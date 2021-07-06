package com.devquickie.minecraftclone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g3d.utils.FirstPersonCameraController;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.IntIntMap;

import java.awt.*;

public class FPSControll extends FirstPersonCameraController {
        Frame frm;
	public Vector3 tmp = new Vector3(0,0,0);
	public Camera camera = MinecraftClone.INSTANCE.camera;
	public Vector3 norm = new Vector3(0,0,0);
	public float speed = 0.9f;
	public IntIntMap keys = new IntIntMap();
        
	public FPSControll(Camera camera) {
		super(camera);
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		touchDragged(screenX, screenY,0);
		return super.mouseMoved(screenX, screenY);
	}

	public void process() {
		for (IntIntMap.Entry key : keys) {
			keyUp(key.key);
			keyDown(key.key);
		}
	}
	
	@Override
	public boolean keyDown(int keycode) {
		keys.put(keycode, keycode);
		if(keycode == Keys.ESCAPE){
			System.out.println("Dispose and Exit");
			MinecraftClone.INSTANCE.dispose();
			Gdx.app.exit();
		}
		if(keycode == Keys.NUM_1) {
			MinecraftClone.INSTANCE.blockType = 1;
		}
		if(keycode == Keys.NUM_2) {
			MinecraftClone.INSTANCE.blockType = 2;
		}
		if(keycode == Keys.NUM_3) {
			MinecraftClone.INSTANCE.blockType = 3;
		}
		if(keycode == Keys.NUM_4) {
			MinecraftClone.INSTANCE.blockType = 4;
		}
		if(keycode == Keys.P) {
			if (MinecraftClone.INSTANCE.physics) {
				MinecraftClone.INSTANCE.physics = false;
			} else {
				MinecraftClone.INSTANCE.physics = true;
			}
		}
		if (keycode == Keys.W) {
			norm.set(camera.direction);
			tmp.set(camera.direction).nor();
			if (camera.direction.y < 0) {
				if (camera.direction.x > 0) {
					tmp.x += -camera.direction.y;
				}
				if (camera.direction.z < 0) {
					tmp.z -= -camera.direction.y;
				}
				if (camera.direction.x < 0) {
					tmp.x -= -camera.direction.y;
				}
				if (camera.direction.z > 0) {
					tmp.z += -camera.direction.y;
				}

			}
			tmp.y = 0;
			tmp.scl(speed);
			camera.position.add(tmp);
		}
		if (keycode == Keys.S) {
			norm.set(camera.direction);
			norm.y = 0;
			tmp.set(camera.direction).nor().scl(-speed);
			camera.position.add(tmp);
		}
		if (keycode == Keys.A) {
			norm.set(camera.direction);
			norm.y = 0;
			tmp.set(camera.direction).crs(camera.up).nor().scl(-speed);
			camera.position.add(tmp);
		}
		if (keycode == Keys.D) {
			norm.set(camera.direction);
			norm.y = 0;
			tmp.set(camera.direction).crs(camera.up).nor().scl(speed);
			camera.position.add(tmp);
		}
		if (keycode == Keys.Q) {
			tmp.set(camera.up).nor().scl(speed);
			camera.position.add(tmp);
		}
		if (keycode == Keys.E) {
			tmp.set(camera.up).nor().scl(-speed);
			camera.position.add(tmp);
		}
		//return super.keyDown(keycode);
		return true;
	}
	@Override
	public boolean keyUp(int keycode) {
		keys.remove(keycode,keycode);
		return true;
	}
}
