package org.academiadecodigo.unbitables;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

public class KeyboardLogic implements KeyboardHandler {

    private Keyboard keyboard;
    private Pointer pointer;
    private MyIO myIO;

    public KeyboardLogic(Pointer pointer, MyIO myIO) {
        keyboard = new Keyboard(this);
        this.pointer = pointer;
        this.myIO = myIO;
    }

    public void init() {
        KeyboardEvent deleteCellOn = new KeyboardEvent();
        deleteCellOn.setKey(KeyboardEvent.KEY_D);
        deleteCellOn.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent deleteCellOff = new KeyboardEvent();
        deleteCellOff.setKey(KeyboardEvent.KEY_D);
        deleteCellOff.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent load = new KeyboardEvent();
        load.setKey(KeyboardEvent.KEY_L);
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent spacePress = new KeyboardEvent();
        spacePress.setKey(KeyboardEvent.KEY_SPACE);
        spacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent spaceRelease = new KeyboardEvent();
        spaceRelease.setKey(KeyboardEvent.KEY_SPACE);
        spaceRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(deleteCellOn);
        keyboard.addEventListener(deleteCellOff);
        keyboard.addEventListener(save);
        keyboard.addEventListener(load);
        keyboard.addEventListener(left);
        keyboard.addEventListener(right);
        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(spacePress);
        keyboard.addEventListener(spaceRelease);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_D:
                System.out.println("Key D PRESSED");
                pointer.setDeleteCell(true);
                break;
            case KeyboardEvent.KEY_S:
                System.out.println("Key D PRESSED");
                try {
                    myIO.saveGame();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                pointer.movePointer(GridDirection.LEFT);
                break;
            case KeyboardEvent.KEY_RIGHT:
                pointer.movePointer(GridDirection.RIGHT);
                break;
            case KeyboardEvent.KEY_UP:
                pointer.movePointer(GridDirection.UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                pointer.movePointer(GridDirection.DOWN);
                break;
            case KeyboardEvent.KEY_SPACE:
                System.out.println("Key SPACE PRESSED");
                pointer.setPaintCell(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                System.out.println("soltou space ======");
                pointer.setPaintCell(false);
                break;
            case KeyboardEvent.KEY_D:
                System.out.println("soltou DELETE =============");
                pointer.setDeleteCell(false);
                break;
        }
    }
}
