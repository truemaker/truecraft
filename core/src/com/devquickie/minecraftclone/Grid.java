package com.devquickie.minecraftclone;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;

import java.util.Random;

import static com.devquickie.minecraftclone.Block.Type.DirtBlock;

public class Grid implements Disposable {
	private final int grid_size = 30;
	private final float field_size = 5;
	public Block field[][][];
	private int before = 0;
	private Random seedgen = new Random();
	private Random seedgen2 = new Random(seedgen.nextLong());
	private Random seedgen3 = new Random(seedgen.nextLong());
	private Random seedgen4 = new Random(seedgen3.nextLong() + seedgen2.nextLong() - seedgen.nextLong());
	private int random;
	private long seed = seedgen4.nextLong();
	private int number = 0;
	private Random extraterrain = new Random();
	public Grid INSTANCE;

	public Grid() {
		INSTANCE = this;
		field = new Block[grid_size][255][grid_size];
		for (int i = 0; i < grid_size; i++) {
			for (int k = 0; k < grid_size; k++) {
				number++;
				if (number > 5) {
					seed = seedgen.nextLong();
				}
				if (number > 10) {
					seed = seedgen.nextLong();
				}
				if (number > 15) {
					seed = seedgen.nextLong();
				}
				if (number > 20) {
					seed = seedgen.nextLong();
				}
				if (number > 6) {
					seed = seedgen.nextLong();
				}
				if (number > 11) {
					seed = seedgen.nextLong();
				}
				if (number > 16) {
					seed = seedgen.nextLong();
				}
				if (number > 19) {
					seed = seedgen.nextLong();
				}

				if (before == 0) {
					before = 2;
				}
				Random rand = new Random();
				rand.setSeed(seed);
				field[i][0][k] = GameRegistry.getBlockByID(10);
				field[i][1][k] = new StoneBlock();
				field[i][2][k] = new StoneBlock();
				field[i][3][k] = new StoneBlock();
				if (rand.nextBoolean()) {
					field[i][1 + rand.nextInt(2)][k] = new RedstoneBlock();
					field[i][1 + rand.nextInt(2)][k] = new CoalBlock();
					field[i][1 + rand.nextInt(2)][k] = new GoldBlock();
				}
				field[i][4][k] = new DirtBlock();
				field[i][5][k] = new DirtBlock();
				field[i][3 + rand.nextInt(4)][k] = new StoneBlock();

				field[i][6][k] = new DirtBlock();
				field[i][7][k] = new DirtBlock();
				random = before + rand.nextInt(1);

				field[i][7][k] = new DirtBlock();
				field[i][7 + random][k] = new DirtBlock();
				field[i][8 + random][k] = new GrassBlock();
				field[i][rand.nextInt(3)][k] = new WaterBlock();

				before = random;
			}
		}
		//postProcess();
		//postProcess();
		updatePosition();
	}

	private void postProcess() {
		for (int i = 0; i < grid_size; i++) {
			for (int k = 0; k < grid_size; k++) {
				for (int y = 20; y > 5; y--) {
					if (field[i][y][k] != null) {
					if (field[i][y][k] != null && field[i][y][k].gettype() != Block.Type.GrassBlock) {
						Boolean kside1 = false;
						Boolean iside1 = false;
						Boolean kside2 = false;
						Boolean iside2 = false;

						if (k - 1 == -1) {
							kside1 = false;
						} else {
							kside1 = true;
						}
						if (i - 1 == -1) {
							iside1 = false;
						} else {
							iside1 = true;
						}
						if (k + 1 < grid_size) {
							kside2 = true;
						} else {
							kside2 = false;
						}
						if (i + 1 < grid_size) {
							iside2 = true;
						} else {
							iside2 = false;
						}
						if (kside1) {
							field[i][y][k - 1] = new GrassBlock();
							if (field[i][y + 1][k] != null) {
								if (field[i][y + 1][k].gettype() == DirtBlock) {
									field[i][y][k - 1] = new DirtBlock();
								}
							}
							field[i][y - 1][k - 1] = new DirtBlock();
						}
						if (kside2) {
							field[i][y][k + 1] = new GrassBlock();
							if (field[i][y + 1][k] != null) {
								if (field[i][y + 1][k].gettype() == DirtBlock) {
									field[i][y][k + 1] = new DirtBlock();
								}
							}
							field[i][y - 1][k + 1] = new DirtBlock();
						}
						if (iside1) {
							field[i - 1][y][k] = new GrassBlock();
							if (field[i][y + 1][k] != null) {
								if (field[i][y + 1][k].gettype() == Block.Type.DirtBlock) {
									field[i - 1][y][k] = new DirtBlock();
								}
							}
							field[i - 1][y - 1][k] = new DirtBlock();
						}
						if (iside2) {
							field[i + 1][y][k] = new GrassBlock();
							if (field[i][y + 1][k] != null) {
								if (field[i][y + 1][k].gettype() == Block.Type.DirtBlock) {
									field[i + 1][y][k] = new DirtBlock();
								}
							}
							field[i + 1][y - 1][k] = new DirtBlock();

						}
						if (field[i][y + 1][k] != null) {
							field[i][y][k] = new DirtBlock();
						}
					}
				}
				}
			}
		}
	}

	public void updatePosition() {
		for (int i = 0; i < grid_size; i++) {
			for (int j = 0; j < grid_size; j++) {
				for (int k = 0; k < grid_size; k++) {
					float x = i * field_size;
					float y = j * field_size;
					float z = k * field_size;
					if (field[i][j][k] != null) {
						field[i][j][k].setPosition(x, y, z);
					}
				}
			}
		}
	}

	public void renderGrid(ModelBatch batch, Environment environment) {
		for (int i = 0; i < grid_size; i++) {
			for (int j = 0; j < grid_size; j++) {
				for (int k = 0; k < grid_size; k++) {
					if (field[i][j][k] != null) {
						batch.render(field[i][j][k].getInstance(), environment);
					}
				}
			}
		}
	}

	@Override
	public void dispose() {
		for (int i = 0; i < grid_size; i++) {
			for (int j = 0; j < 255; j++) {
				for (int k = 0; k < grid_size; k++) {
					if (field[i][j][k] != null) {
						field[i][j][k].dispose();
					}
				}
			}
		}
	}

	public void editBoxByRayCast(Vector3 start_point, Vector3 direction, Block.Type type) {
		int last_point_x = 0;
		int last_point_y = 0;
		int last_point_z = 0;

		for (int i = 1; i < grid_size * 2; i++) {
			Vector3 tmp_start = new Vector3(start_point);
			Vector3 tmp_direction = new Vector3(direction);
			tmp_direction.nor();
			tmp_direction.scl(i);
			Vector3 line = tmp_start.add(tmp_direction);
			// scale to grid wolrd
			line.scl(1 / field_size);
			int x = Math.round(line.x);
			int y = Math.round(line.y);
			int z = Math.round(line.z);

			if (x > (grid_size - 1) || y > (grid_size - 1) || z > (grid_size - 1) || x < 0 || y < 0 || z < 0) {
				break;
			}

			if (field[x][y][z] != null) {
				if (type == null) {
					if (field[x][y][z] != null) {
						//field[x][y][z].dispose();
						field[x][y][z] = null;
						updatePosition();
					}
				} else if (type == Block.Type.DirtBlock) {
					field[last_point_x][last_point_y][last_point_z] = new DirtBlock();
					updatePosition();
				} else if (type == Block.Type.GrassBlock) {
					field[last_point_x][last_point_y][last_point_z] = new GrassBlock();
					updatePosition();
				} else if (type == Block.Type.WoodBlock1) {
					field[last_point_x][last_point_y][last_point_z] = new WoodBlock();
					updatePosition();
				} else if (type == Block.Type.WoodBlock2) {
					field[last_point_x][last_point_y][last_point_z] = new woodBlock();
					updatePosition();
				}
				break;
			}

			last_point_x = x;
			last_point_y = y;
			last_point_z = z;
		}
	}

	// for collision detection...
	public boolean hittingBox(Vector3 point) {
		point.scl(1 / field_size);
		int x = Math.round(point.x / 5);
		int y = Math.round(point.y / 5);
		int z = Math.round(point.z / 5);

		return field[x][y][z] != null;
	}
	public float deepness(Vector3 pos) {
		int x = Math.round(pos.x / 5);
		int y = Math.round(pos.y / 5) - 2;
		int z = Math.round(pos.z / 5);
		for (float i = y; i<15f; i++) {
			if (field[x][(int) i][z] == null) {
				if (i - (float) y != 0f) {
					return i - y;
				}
				return 0f;
			}
		}
		return 0f;
	}
}
