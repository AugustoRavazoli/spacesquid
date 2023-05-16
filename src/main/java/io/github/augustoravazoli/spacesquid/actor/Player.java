package io.github.augustoravazoli.spacesquid.actor;

import io.github.augustoravazoli.spacesquid.input.KeyHandler;

public class Player {

  private int x;
  private int y;
  private int speed;

  public Player(int x, int y, int speed) {
    this.x = x;
    this.y = y;
    this.speed = speed;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getSpeed() {
    return speed;
  }

  public void move() {
    if (KeyHandler.INSTANCE.isUpPressed()) {
      y -= speed;
    }
    if (KeyHandler.INSTANCE.isDownPressed()) {
      y += speed;
    }
    if (KeyHandler.INSTANCE.isLeftPressed()) {
      x -= speed;
    }
    if (KeyHandler.INSTANCE.isRightPressed()) {
      x += speed;
    }
  }

}
