package com.devquickie.minecraftclone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class GoldBlock extends Block {
	public GoldBlock() {
		super(new Texture(Gdx.files.internal("texture/Gold.PNG")), Type.DirtBlock);
	}
}
