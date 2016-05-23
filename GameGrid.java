package com.example.sadeqnairat.watashinosudoko;

import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;

/**
 * Created by Sadeq Nairat on 5/23/2016.
 */
public class GameGrid {
    private Cell[][] sudoko = new Cell[9][9];

    private Context context;

    public GameGrid( Context context ){
        this.context = context;
        for( int x = 0 ; x < 9 ; x++ ){
            for( int y = 0 ; y < 9 ; y++){
                sudoko[x][y] = new Cell(context);
            }
        }
    }

    public void setGrid( int[][] grid ){
        for( int x = 0 ; x < 9 ; x++ ){
            for( int y = 0 ; y < 9 ; y++){
                sudoko[x][y].setMasterNumber(grid[x][y]);
                if( grid[x][y] != 0 ){
                    sudoko[x][y].masterify();
                }
            }
        }
    }

    public Cell[][] getGrid(){
        return sudoko;
    }

    public Cell getItem(int x , int y ){
        return sudoko[x][y];
    }

    public Cell getItem( int position ){
        int x = position % 9;
        int y = position / 9;

        return sudoko[x][y];
    }

    public void setItem( int x , int y , int number ){
        sudoko[x][y].setNumber(number);
    }

    public boolean checkGame(){
        int [][] sudGrid = new int[9][9];
        for( int x = 0 ; x < 9 ; x++ ){
            for( int y = 0 ; y < 9 ; y++ ){
                sudGrid[x][y] = getItem(x,y).getNumber();
            }
        }

        if( WinCheck.getInstance().checkSudoku(sudGrid)){
            return true;
        }
        else{
            return false;
        }

    }
}
