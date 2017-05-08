package gamewindow;

import gamelogic.SneakGame;
import gamelogic.Tuning;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import libraries.ImageTools;
import libraries.Logger;

/**
 * The panel of the game.
 *
 * @author Noah Morton
 *
 * Date created: May 3, 2017
 *
 * Part of project: ScrollingGame
 */
public class SneakPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener, Runnable {

    private BufferedImage buffer;
    BufferedImage grass, ice, mud, sand, stone, stoneBricks, water, wood, voidTile;
    private SneakGame game;

    public SneakPanel() {
        setSize(Tuning.SCREEN_WIDTH, Tuning.SCREEN_HEIGHT);
        buffer = new BufferedImage(Tuning.SCREEN_WIDTH, Tuning.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);

        //load all images
        grass = ImageTools.load("resources/grass.png");
        ice = ImageTools.load("resources/ice.png");
        mud = ImageTools.load("resources/mud.png");
        sand = ImageTools.load("resources/sand.png");
        stone = ImageTools.load("resources/stone.png");
        stoneBricks = ImageTools.load("resources/stone-bricks.png");
        water = ImageTools.load("resources/water.png");
        wood = ImageTools.load("resources/wood.png");
        voidTile = ImageTools.load("resources/void-tile.png");

        game = new SneakGame();

        addMouseListener(this);
        addMouseMotionListener(this);

        Logger.logCodeMessage("Initialized panel.");

    }

    public void paint(Graphics g) {
        Graphics bg = buffer.getGraphics();
        drawMap(bg);
        if (Tuning.DEBUG) {
            drawGuidelines(bg, true);
        }

        g.drawImage(buffer, 0, 0, null);
    }

    private void drawMap(Graphics g) {
        for (int x = 0; x < Tuning.MAP_WIDTH * Tuning.TILE_SIZE; x += Tuning.TILE_SIZE) {
            for (int y = 0; y < Tuning.MAP_HEIGHT * Tuning.TILE_SIZE; y += Tuning.TILE_SIZE) {
                switch (game.getGrid()[y / Tuning.TILE_SIZE][x / Tuning.TILE_SIZE].getType()) {
                    case 0: //grass
                        g.drawImage(grass, x, y, null);
                        break;
                    case 1: //ice
                        g.drawImage(ice, x, y, null);
                        break;
                    case 2: //mud
                        g.drawImage(mud, x, y, null);
                        break;
                    case 3: //sand
                        g.drawImage(sand, x, y, null);
                        break;
                    case 4: //stone
                        g.drawImage(stone, x, y, null);
                        break;
                    case 5: //stone bricks
                        g.drawImage(stoneBricks, x, y, null);
                        break;
                    case 6: //water
                        g.drawImage(water, x, y, null);
                        break;
                    case 7: //wood
                        g.drawImage(wood, x, y, null);
                        break;
                    case 8: //void
                        g.drawImage(voidTile, x, y, null);
                        break;
                    default:
                        System.err.println("Cannot determine image to draw from tile type: " + game.getGrid()[x / Tuning.TILE_SIZE][y / Tuning.TILE_SIZE].getType());
                        break;
                }
            }
        }
    }

    /**
     * Draws guidelines based on tile size and screen size. Used for positioning tiles.
     *
     * @param g Graphics to paint the lines onto.
     */
    private void drawGuidelines(Graphics g, final boolean drawNums) {
        g.setColor(Color.BLACK);
        for (int x = 0; x < Tuning.SCREEN_WIDTH; x += Tuning.TILE_SIZE) {
            g.drawLine(x, 0, x, Tuning.SCREEN_HEIGHT);
        }
        for (int y = 0; y < Tuning.SCREEN_WIDTH; y += Tuning.TILE_SIZE) {
            g.drawLine(0, y, Tuning.SCREEN_WIDTH, y);
        }
        if (!drawNums) {
            return;
        }
        g.setFont(new Font("Arial", Font.BOLD, 8));
        int counter = 1;
        for (int i = 10; i < Tuning.SCREEN_HEIGHT; i += Tuning.TILE_SIZE) {
            g.drawString("" + counter, 5, i);
            counter++;
        }
        counter = 1;
        for (int i = 5; i < Tuning.SCREEN_WIDTH; i += Tuning.TILE_SIZE) {
            g.drawString("" + counter, i, 8);
            counter++;
        }
    }

    public void run() {
        //noinspection InfiniteLoopStatement
        while (true) {
            repaint();
            try {
                Thread.sleep(35);
            } catch (InterruptedException e) {
                System.err.println("Error Sleeping.");
                Logger.logErrorMessage("Error Sleeping Thread.");
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}
