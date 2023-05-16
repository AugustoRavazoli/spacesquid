package io.github.augustoravazoli.spacesquid;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import io.github.augustoravazoli.spacesquid.input.KeyHandler;

class GamePanel extends JPanel {

  final int originalTileSize = 16;
  final int scaleFactor = 3;
  final int tileSize = originalTileSize * scaleFactor;
  final int maxScreenColumns = 16;
  final int maxScreenRows = 12;
  final int screenWidth = tileSize * maxScreenColumns;
  final int screenHeight = tileSize * maxScreenRows;

  private Thread gameThread;
  private GameLoop gameLoop;

  public GamePanel() {
    setPreferredSize(new Dimension(screenWidth, screenHeight));
    setDoubleBuffered(true);
    addKeyListener(KeyHandler.INSTANCE);
    setFocusable(true);
  }

  public void startGameThread() {
    gameLoop = new GameLoop(this);
    gameThread = new Thread(gameLoop);
    gameThread.start();
  }

  @Override
  protected void paintComponent(Graphics graphics) {
    super.paintComponent(graphics);
    gameLoop.draw(graphics);
  }

}
