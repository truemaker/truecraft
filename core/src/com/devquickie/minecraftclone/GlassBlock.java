package com.devquickie.minecraftclone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class GlassBlock extends Block {
	public GlassBlock() {
		super(new Texture(Gdx.files.internal("texture/Glass.PNG")), Type.DirtBlock);
	}
}
