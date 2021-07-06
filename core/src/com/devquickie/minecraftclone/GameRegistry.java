package com.devquickie.minecraftclone;

import com.badlogic.gdx.graphics.Texture;

import java.util.concurrent.CopyOnWriteArrayList;

public class GameRegistry {
    public static CopyOnWriteArrayList<Block> BLOCKS;
    public static CopyOnWriteArrayList<Texture> TEXTURES;
    public static void setup() {
        BLOCKS = new CopyOnWriteArrayList<Block>();
        TEXTURES = new CopyOnWriteArrayList<Texture>();
    }
    public static void registerBlock(Block block) {
        BLOCKS.add(block);
    }
    public static void registerTexture(Texture texture) {
        TEXTURES.add(texture);
    }
    public static Texture getTextureByID(int id) {
        try {
            Texture tex = TEXTURES.get(id);
            return tex;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Block getBlockByID(int id) {
        try {
            Block block = BLOCKS.get(id);
            Block block1 = block.getClass().newInstance();
            return block1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
