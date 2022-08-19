package org.academiadecodigo.unbitables;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PaintGame {

    private MyGrid grid;
    private KeyboardLogic keyboardLogic;
    private MyIO myIO;
    private Pointer pointer;

    public PaintGame(MyGrid grid, Pointer pointer) throws IOException {
        this.grid = grid;
        this.pointer = pointer;
        myIO = new MyIO(grid);
    }
    public void init(){
        keyboardLogic = new KeyboardLogic(pointer,myIO);
        keyboardLogic.init();
    }
}
