package org.academiadecodigo.unbitables;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import javax.annotation.Resources;
import java.io.*;

public class MyIO {
    private MyGrid grid;
    private Cell[][] cellgrid;

    private String myString = "";

    BufferedWriter bwriter;

    public MyIO(MyGrid grid) throws IOException {
        this.grid = grid;
        cellgrid = grid.getCellgrid();
    }

    public void saveGame() throws IOException {
        bwriter = new BufferedWriter(new FileWriter("Resources/savegame.txt"));

        for (int col = 0; col < cellgrid.length; col++) {
            for (int row = 0; row < cellgrid[col].length; row++) {
                myString += cellgrid[col][row].getCellPainted();
            }
            myString += "\n";
        }
        System.out.println(myString);
        bwriter.write(myString);
        bwriter.close();
    }

    public void loadGame(){

    }

}
