package com.devquickie.minecraftclone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class RedstoneBlock extends Block {
	public RedstoneBlock() {
		super(new Texture(Gdx.files.internal("texture/Redstone.PNG")), Type.DirtBlock);
	}
}
