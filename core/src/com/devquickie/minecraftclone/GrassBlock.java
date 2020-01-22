package com.devquickie.minecraftclone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class GrassBlock extends Block {
	public GrassBlock() {
		super(new Texture(Gdx.files.internal("texture/Grass.PNG")), Type.DirtBlock);
	}
}
