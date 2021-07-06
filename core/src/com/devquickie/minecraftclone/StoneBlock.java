package com.devquickie.minecraftclone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class StoneBlock extends Block {
    public NBTData nbt;
	public StoneBlock() {
		super(GameRegistry.getTextureByID(8), Type.StoneBlock);
	}
}
