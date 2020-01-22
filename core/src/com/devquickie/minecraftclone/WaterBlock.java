package com.devquickie.minecraftclone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class WaterBlock extends Block {
	public WaterBlock() {
		super(new Texture(Gdx.files.internal("texture/Water.PNG")), Type.DirtBlock);
	}
}
