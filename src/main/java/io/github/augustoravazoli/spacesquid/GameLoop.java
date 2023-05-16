package io.github.augustoravazoli.spacesquid;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import io.github.augustoravazoli.spacesquid.actor.Player;

class GameLoop implements Runnable {

	private static final int FPS = 60;
  private final GamePanel gamePanel;

  private Player player = new Player(100, 100, 5);

  public GameLoop(GamePanel gamePanel) {
    this.gamePanel = gamePanel;
  }

  @Override
  public void run() {
    var drawInterval = 1_000_000_000.0 / FPS;
    var delta = 0.0;
    var lastTime = System.nanoTime();
    var currentTime = 0L;
    while (true) {
      currentTime = System.nanoTime();
      delta += (currentTime - lastTime) / drawInterval;
      lastTime = currentTime;
      if (delta >= 1) {
        update();
        gamePanel.repaint();
        delta--;
      }
    }
  }

  void sleep(long remaining) {
    try {
      Thread.sleep(remaining);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }

  void update() {
    player.move(); 
  }

  void draw(Graphics graphics) {
    var graphics2d = (Graphics2D) graphics;
    graphics2d.setColor(Color.RED);
    graphics2d.fillRect(player.getX(), player.getY(), gamePanel.tileSize, gamePanel.tileSize);
    graphics2d.dispose();
  }

}
