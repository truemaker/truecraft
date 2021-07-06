package com.devquickie.minecraftclone;

import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Disposable;

public class Chunk implements Disposable {
	private final int grid_size = 10;
	private final float field_size = 5;
	private Block field[][][];

	public Chunk() {
		field = new Block[grid_size][grid_size][grid_size];
		for (int i = 0; i < grid_size; i++) {
			for (int k = 0; k < grid_size; k++) {
				field[i][0][k] = new StoneBlock();
                                field[i][1][k] = new DirtBlock();
                                field[i][2][k] = new DirtBlock();
                                field[i][3][k] = new DirtBlock();
                                field[i][4][k] = new GrassBlock();
			}
		}
		updatePosition();
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
			for (int j = 0; j < grid_size; j++) {
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
						field[x][y][z].dispose();
						field[x][y][z] = null;
						updatePosition();
					}
				} else if (type == Block.Type.DirtBlock) {
					field[last_point_x][last_point_y][last_point_z] = new DirtBlock();
					updatePosition();
				}
				break;
			}

			last_point_x = x;
			last_point_y = y;
			last_point_z = z;
		}
	}

	// for collition detection...
	public boolean hittingBox(Vector3 point) {
		point.scl(1 / field_size);
		int x = Math.round(point.x);
		int y = Math.round(point.y);
		int z = Math.round(point.z);
		
		if(field[x][y][z] != null){
			return true;
		} else {
			return false;
		}
	}
}

