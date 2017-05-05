package gamelogic;

import tiles.Tile;

/**
 * Game class that holds the game.
 *
 * @author Noah Morton
 *
 * Date created: May 5, 2017
 *
 * Part of project: ScrollingGame
 */
public class SneakGame {

    private Tile[][] grid;

    public SneakGame() {
        grid = new Tile[Tuning.MAP_HEIGHT][Tuning.MAP_WIDTH];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid.length; y++) {
                grid[x][y] = new Tile(x, y, (int) (Math.random() * 7));

                //todo fix this for loop
            }

        }
    }

}