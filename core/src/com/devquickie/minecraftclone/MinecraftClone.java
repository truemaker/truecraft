package com.devquickie.minecraftclone;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.btBoxBoxCollisionAlgorithm;
import com.badlogic.gdx.physics.bullet.collision.btCollisionConfiguration;
import com.badlogic.gdx.physics.bullet.collision.btCollisionObject;
import com.badlogic.gdx.physics.bullet.collision.btDispatcher;


public class MinecraftClone extends ApplicationAdapter {
    public final float field_of_view = 67;
    public final float camera_near = 1;
    public final float camera_far = 300;
    public final float camera_velocity = 15;
    public final float camera_degrees_per_pixel = 0.08f;
    public final float crosshair_size = 25;
    public int blockType = 1;
    public static MinecraftClone INSTANCE;
    public FPSControll camera_controller;
    public Environment environment;
    public ModelBatch model_batch;
    public SpriteBatch sprite_batch;
    public PerspectiveCamera camera;
    public PerspectiveCamera camera2;
    public Grid grid;
    public Texture crosshair;
    private String ver;
    public boolean physics = true;
    public BlockMap map;
    public btCollisionConfiguration collisionConfig;
    public btDispatcher dispatcher;

    public MinecraftClone() {
        INSTANCE = this;
    }

    @Override
    public void create() {
        GameRegistry.setup();
        TextureMapping.create();
        ver = "1.0";
        System.out.println("Hello" + ver);
        System.out.println("Define Engine");
        model_batch = new ModelBatch();
        sprite_batch = new SpriteBatch();

        System.out.println("Generate Sky");
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.5f, 0.5f, 0.5f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.5f));
        environment.add(new DirectionalLight().set(0.2f, 0.2f, 0.2f, 1f, 0.8f, 0.5f));

        System.out.println("Generate Player");
        camera = new PerspectiveCamera(field_of_view, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera2 = new PerspectiveCamera(field_of_view / 2, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        camera.position.set(0, 90f, 10f);
        camera2.position.set(0, 70, 0);
        camera2.direction.set(new Vector3(0, 0, 0));
        camera.near = camera_near;
        camera.far = camera_far;
        camera2.near = camera_near;
        camera2.far = camera_far;
        camera2.project(new Vector3(10, 70, 10));
        System.out.println("start Render Event");
        camera.update();
        System.out.println("Generate flat world");
        map = new BlockMap();
        grid = new Grid();

        crosshair = new Texture(Gdx.files.internal("interface/Crosshair.png"));

        camera_controller = new FPSControll(camera) {
            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                if (button == 1 && blockType == 1) {
                    grid.editBoxByRayCast(camera.position, camera.direction, Block.Type.DirtBlock);
                }
                if (button == 1 && blockType == 3) {
                    grid.editBoxByRayCast(camera.position, camera.direction, Block.Type.WoodBlock1);
                }
                if (button == 1 && blockType == 4) {
                    grid.editBoxByRayCast(camera.position, camera.direction, Block.Type.WoodBlock2);
                }
                if (button == 1 && blockType == 2) {
                    grid.editBoxByRayCast(camera.position, camera.direction, Block.Type.GrassBlock);
                } else if (button == 0) {
                    grid.editBoxByRayCast(camera.position, camera.direction, null);
                }
                return super.touchDown(screenX, screenY, pointer, button);
            }
        };
        System.out.println("Start Event Handler");
        camera_controller.setDegreesPerPixel(camera_degrees_per_pixel * 3);
        camera_controller.setVelocity(camera_velocity * 2);
        Gdx.input.setInputProcessor(camera_controller);
        Gdx.input.setCursorCatched(true);
    }

    @Override
    public void render() {
        final float delta = Math.min(1f / 30f, Gdx.graphics.getDeltaTime());
        camera_controller.update();
        camera_controller.process();
        Gdx.gl.glClearColor(0.5f, 0.8f, 1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glEnable(Gdx.gl.GL_CULL_FACE);
        Gdx.gl.glCullFace(Gdx.gl.GL_BACK);
        model_batch.begin(camera);
        grid.renderGrid(model_batch, environment);
        model_batch.end();

        float crosshair_x = (Gdx.graphics.getWidth() - crosshair_size) / 2;
        float crosshair_y = (Gdx.graphics.getHeight() - crosshair_size) / 2;

        sprite_batch.begin();
        sprite_batch.draw(crosshair, crosshair_x, crosshair_y, crosshair_size, crosshair_size);
        sprite_batch.end();
    }

    @Override
    public void dispose() {
        grid.dispose();
        model_batch.dispose();
        sprite_batch.dispose();
    }
}
