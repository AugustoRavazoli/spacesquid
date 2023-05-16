package io.github.augustoravazoli.spacesquid.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public enum KeyHandler implements KeyListener {

  INSTANCE;

  private boolean upPressed, downPressed, leftPressed, rightPressed;

  public boolean isUpPressed() {
    return upPressed;
  }

  public boolean isDownPressed() {
    return downPressed;
  }

  public boolean isLeftPressed() {
    return leftPressed;
  }

  public boolean isRightPressed() {
    return rightPressed;
  }

  @Override
  public void keyTyped(KeyEvent event) {}

  @Override
  public void keyPressed(KeyEvent event) {
    setKey(event.getKeyCode(), true);
  }

  @Override
  public void keyReleased(KeyEvent event) {
    setKey(event.getKeyCode(), false);
  }

  private void setKey(int keyCode, boolean value) {
    switch (keyCode) {
      case KeyEvent.VK_W -> upPressed = value;
      case KeyEvent.VK_S -> downPressed = value;
      case KeyEvent.VK_A -> leftPressed = value;
      case KeyEvent.VK_D -> rightPressed = value;
    }
  }

}
