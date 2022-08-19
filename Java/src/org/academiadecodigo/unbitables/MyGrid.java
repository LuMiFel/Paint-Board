package org.academiadecodigo.unbitables;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class MyGrid {
    private int cols;
    private int rows;
    private int width;
    private int height;
    private final int x;
    private final int y;
    private Cell[][] cellgrid;
    private final int cellSize = 20;
    private Rectangle rectangle;
    private int PADDING = 10;

    private Line line;



    public MyGrid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        width = cols * cellSize;
        height = rows * cellSize;
        x = cols * cellSize + PADDING;
        y = rows * cellSize + PADDING;
        rectangle = new Rectangle(PADDING, PADDING, width, height);
        cellgrid = new Cell[rows][cols];
    }

    public void init() {
        rectangle.draw();
        //drawLinesX();
        //drawLinesY();
        createCells();
    }

    public void drawLinesX() {
        int counter = 0;
        int lines = 0;
        while (counter < rows) {
            line = new Line(PADDING, cellSize + PADDING + lines, width + PADDING, cellSize + PADDING + lines);
            line.draw();
            counter++;
            lines += cellSize;
        }
    }

    public void drawLinesY() {
        int counter = 0;
        int lines = 0;
        while (counter < cols) {
            line = new Line(cellSize + PADDING + lines, PADDING, cellSize + PADDING + lines, height + PADDING);
            line.draw();
            counter++;
            lines += cellSize;
        }
    }

    public void createCells() {
        for (int col = 0; col < cellgrid.length; col++) {
            for (int row = 0; row < cellgrid[col].length; row++) {

                cellgrid[col][row] = new Cell(row, col, this);
                System.out.println(row + " " + col);
                cellgrid[col][row].getCell().draw();
            }
        }
    }
    public Cell[][] getCellgrid(){
        return cellgrid;
    }

    public void paintCell(int pointerX, int pointerY) {
        cellgrid[pointerY/cellSize][pointerX/cellSize].paintCell();
    }
    public void deleteCell(int pointerX, int pointerY) {
        cellgrid[pointerY/cellSize][pointerX/cellSize].deleteCell();
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return rectangle.getX();
    }

    public int getY() {
        return rectangle.getY();
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getPADDING() {
        return PADDING;
    }

    public int rowToY(int row) {
        return row * getCellSize() + PADDING;
    }

    public int columnToX(int column) {
        return column * getCellSize() + PADDING;
    }

}
