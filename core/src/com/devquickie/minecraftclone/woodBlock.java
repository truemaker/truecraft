package com.devquickie.minecraftclone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class woodBlock extends Block {
	public woodBlock() {
		super(new Texture(Gdx.files.internal("texture/wood.PNG")), Type.DirtBlock);
	}
}
