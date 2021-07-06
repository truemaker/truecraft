package com.devquickie.minecraftclone;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureMapping {
    public static Texture grass;
    public static Texture coal;
    public static Texture dirt;
    public static Texture glass;
    public static Texture gold;
    public static Texture leaves;
    public static Texture redstone;
    public static Texture sand;
    public static Texture stone;
    public static Texture tnt;
    public static Texture water;
    public static Texture Wood;
    public static Texture wood;
    public static TextureMapping INSTANCE;
    public TextureMapping() {
        INSTANCE = this;
    }
    public static void create() {
        GameRegistry.registerTexture(new Texture(Gdx.files.internal("texture/Grass.PNG"))); // 0
        GameRegistry.registerTexture(new Texture(Gdx.files.internal("texture/Coat.PNG"))); // 1
        GameRegistry.registerTexture(new Texture(Gdx.files.internal("texture/Dirt.PNG"))); // 2
        GameRegistry.registerTexture(new Texture(Gdx.files.internal("texture/Glass.PNG"))); // 3
        GameRegistry.registerTexture(new Texture(Gdx.files.internal("texture/Gold.PNG"))); // 4
        GameRegistry.registerTexture(new Texture(Gdx.files.internal("texture/Leaves.PNG"))); // 5
        GameRegistry.registerTexture(new Texture(Gdx.files.internal("texture/Redstone.PNG"))); // 6
        GameRegistry.registerTexture(new Texture(Gdx.files.internal("texture/Sand.PNG"))); // 7
        GameRegistry.registerTexture(new Texture(Gdx.files.internal("texture/Stone.PNG"))); // 8
        GameRegistry.registerTexture(new Texture(Gdx.files.internal("texture/Tnt.PNG"))); // 9
        GameRegistry.registerTexture(new Texture(Gdx.files.internal("texture/Water.PNG"))); // 10
        GameRegistry.registerTexture(new Texture(Gdx.files.internal("texture/Wood.PNG"))); // 11
        GameRegistry.registerTexture(new Texture(Gdx.files.internal("texture/wood.PNG"))); // 12
    }
}