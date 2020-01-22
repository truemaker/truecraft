package com.devquickie.minecraftclone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class WoodBlock extends Block {
	public WoodBlock() {
		super(new Texture(Gdx.files.internal("texture/Wood.PNG")), Type.DirtBlock);
	}
}
