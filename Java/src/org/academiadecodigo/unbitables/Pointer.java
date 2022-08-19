package org.academiadecodigo.unbitables;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Pointer {
    private Rectangle pointer;
    private MyGrid grid;
    private boolean paintCell = false;

    private boolean deleteCell = false;


    public Pointer(MyGrid grid) {
        this.grid = grid;
        pointer = new Rectangle(grid.getPADDING(), grid.getPADDING(), grid.getCellSize(), grid.getCellSize());
        pointer.setColor(Color.GREEN);
    }

    public void init() {
        pointer.fill();
    }

    public void setPaintCell(boolean paint) {
        paintCell = paint;
    }

    public void setDeleteCell(boolean delete) {
        deleteCell = delete;
    }

    public void movePointer(GridDirection gridDirection) {
        System.out.println("paintCell: " + paintCell + " || deleteCell: " + deleteCell);
        switch (gridDirection) {
            case LEFT:
                if (pointer.getX() > grid.getCellSize()) {
                    if (paintCell) grid.paintCell(pointer.getX(), pointer.getY());
                    if (deleteCell) grid.deleteCell(pointer.getX(), pointer.getY());
                    pointer.translate(-grid.getCellSize(), 0);
                }
                break;
            case RIGHT:
                if (pointer.getX() < grid.getWidth() - grid.getCellSize()) {
                    if (paintCell) grid.paintCell(pointer.getX(), pointer.getY());
                    if (deleteCell) grid.deleteCell(pointer.getX(), pointer.getY());
                    pointer.translate(grid.getCellSize(), 0);
                }
                break;
            case UP:
                if (pointer.getY() > grid.getCellSize()) {
                    if (paintCell) grid.paintCell(pointer.getX(), pointer.getY());
                    if (deleteCell) grid.deleteCell(pointer.getX(), pointer.getY());
                    pointer.translate(0, -grid.getCellSize());
                }
                break;
            case DOWN:
                if (pointer.getY() < grid.getHeight() - grid.getCellSize()) {
                    if (paintCell) grid.paintCell(pointer.getX(), pointer.getY());
                    if (deleteCell) grid.deleteCell(pointer.getX(), pointer.getY());
                    pointer.translate(0, grid.getCellSize());
                }
                break;
        }
    }
}
