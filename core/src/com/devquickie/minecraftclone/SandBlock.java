package com.devquickie.minecraftclone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class SandBlock extends Block {
	public SandBlock() {
		super(new Texture(Gdx.files.internal("texture/Sand.PNG")), Type.DirtBlock);
	}
}
