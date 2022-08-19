package org.academiadecodigo.unbitables;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MyGrid newGrid = new MyGrid(30,20);
        newGrid.init();

        Pointer newPointer = new Pointer(newGrid);
        newPointer.init();

        PaintGame painter = new PaintGame(newGrid,newPointer);
        painter.init();

    }
}
