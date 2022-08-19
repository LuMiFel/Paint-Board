package org.academiadecodigo.unbitables;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {
    private Color color;
    private int myX;
    private int myY;
    private Rectangle cell;
    private MyGrid grid;

    private int cellPainted = 0;

    public Cell(int x, int y, MyGrid grid) {
        this.grid = grid;
        this.myX = x * grid.getCellSize() + grid.getPADDING();
        this.myY = y * grid.getCellSize() + grid.getPADDING();

        cell = new Rectangle(myX, myY, grid.getCellSize(), grid.getCellSize());
        cell.setColor(Color.BLACK);
    }

    public Rectangle getCell() {
        return cell;
    }

    public int getCellPainted(){
        return cellPainted;
    }

    public void paintCell() {
        cell.fill();
        cellPainted = 1;
    }

    public void deleteCell() {
        cell.draw();
        cellPainted = 0;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }


    public int getX() {
        return myX;
    }

    public int getY() {
        return myY;
    }
}
