package com.devquickie.minecraftclone;

public class BlockMap {
    public GrassBlock grass;
    public DirtBlock dirt;
    public CoalBlock coal;
    public GlassBlock glass;
    public GoldBlock gold;
    public LeavesBlock leaves;
    public RedstoneBlock redstone;
    public SandBlock sand;
    public StoneBlock stone;
    public TntBlock tnt;
    public WaterBlock water;
    public WoodBlock wood1;
    public woodBlock wood2;
    public static BlockMap INSTANCE;
    public BlockMap() {
        GameRegistry.registerBlock(new GrassBlock());
        GameRegistry.registerBlock(new DirtBlock());
        GameRegistry.registerBlock(new CoalBlock());
        GameRegistry.registerBlock(new GlassBlock());
        GameRegistry.registerBlock(new GoldBlock());
        GameRegistry.registerBlock(new LeavesBlock());
        GameRegistry.registerBlock(new RedstoneBlock());
        GameRegistry.registerBlock(new SandBlock());
        GameRegistry.registerBlock(new StoneBlock());
        GameRegistry.registerBlock(new TntBlock());
        GameRegistry.registerBlock(new WaterBlock());
        GameRegistry.registerBlock(new WoodBlock());
        GameRegistry.registerBlock(new woodBlock());
        INSTANCE = this;
    }
}
