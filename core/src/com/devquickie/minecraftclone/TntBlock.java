package com.devquickie.minecraftclone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TntBlock extends Block {
	public TntBlock() {
		super(new Texture(Gdx.files.internal("texture/Tnt.PNG")), Type.DirtBlock);
	}
}
