package com.devquickie.minecraftclone;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;

public class GuiBasic {
	public final float field_of_view = 67;
	public final float camera_near = 1;
	public final float camera_far = 300;
	public final float camera_velocity = 15;
	public final float camera_degrees_per_pixel = 0.08f;
	public final float crosshair_size = 25;

	public SpriteBatch sprite_batch;
	public Texture gui;

    public void create() {
        gui = new Texture(Gdx.files.internal("interface/Crosshair.png"));
        System.out.println("createt");

    }
    public void render() {
		Gdx.gl.glClearColor(0.5f, 0.8f, 1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        float crosshair_x = (Gdx.graphics.getWidth() - crosshair_size) / 2;
		float crosshair_y = (Gdx.graphics.getHeight() - crosshair_size) / 2;

		sprite_batch.begin();
		sprite_batch.draw(gui, crosshair_x, crosshair_y, crosshair_size, crosshair_size);
		sprite_batch.end();
        System.out.println("render");
    }
}
