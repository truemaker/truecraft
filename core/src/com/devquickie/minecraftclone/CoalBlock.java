package com.devquickie.minecraftclone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class CoalBlock extends Block {
	public CoalBlock() {
		super(GameRegistry.getTextureByID(1), Type.DirtBlock);
	}
}
