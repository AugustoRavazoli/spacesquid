package io.github.augustoravazoli.spacesquid;

import javax.swing.JFrame;

public class Main {

  public static void main(String[] args) {
    var gamePanel = new GamePanel();
    var window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(false);
    window.setTitle("Space Squid");
    window.add(gamePanel);
    window.pack();
    window.setLocationRelativeTo(null);
		window.setVisible(true);
    gamePanel.startGameThread();
  }

}
