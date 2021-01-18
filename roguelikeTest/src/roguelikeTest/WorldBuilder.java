package roguelikeTest;

public class WorldBuilder {

	private int width;
	private int height;
	private Tile[][] tiles;
	
	public WorldBuilder(int width, int height) {
		this.width = width;
		this.height = height;
		this.tiles = new Tile[width][height];
	}
	
	public World build() {
		return new World(tiles);
	}
	
	private WorldBuilder randomizeTiles() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (Math.random() < 0.5) {
					tiles[x][y] = Tile.FLOOR;					
				}
				else {
					tiles[x][y] = Tile.WALL;
				}
			}
		}
		return this;
	}
	
	private WorldBuilder smooth(int times) {
		Tile[][] tiles2 = new Tile[width][height];
		for (int time = 0; time < times; time++) {
			for (int x = 0; x < width; x++) {
				for (int y = 0; y < height; y++) {
					int floors = 0;
					int walls = 0;
					
					for (int ox = -1; ox <= 1; ox++) {
						for (int oy = -1; oy <= 1; oy++) {
							if (x + ox < 0 || x + ox >= width || y + oy < 0 || y + oy >= height) {
								continue;
							}
							if (tiles[x + ox][y + oy] == Tile.FLOOR) floors++;
							if (tiles[x + ox][y + oy] == Tile.WALL) walls++;
						}
					}
					if (floors >= walls) {
						tiles2[x][y] = Tile.FLOOR;						
					}
					else {
						tiles2[x][y] = Tile.WALL;
					}
					
				}
			}
			tiles = tiles2;
		}
		return this;
	}
	
	public WorldBuilder makeCaves() {
		return randomizeTiles().smooth(8);
	}
	
}
