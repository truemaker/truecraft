package com.devquickie.minecraftclone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class LeavesBlock extends Block {
	public LeavesBlock() {
		super(new Texture(Gdx.files.internal("texture/Leaves.PNG")), Type.DirtBlock);
	}
}
