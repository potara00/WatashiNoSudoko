package com.example.sadeqnairat.watashinosudoko;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mohammad Sadeq Nairat on 5/22/2016.
 */
public class LevelManager {
    private static LevelManager instance;

    private GameGrid grid = null;

    private int selectedPosX = -1, selectedPosY = -1;

    private LevelManager(){}

    public static LevelManager getInstance(){
        if( instance == null ){
            instance = new LevelManager();
        }
        return instance;
    }

    public void createGrid( Context context ){
        int[][] Sudoku = SudokuHades.getInstance().conjureUnDoneSudoko();
        grid = new GameGrid(context);
        grid.setGrid(Sudoku);
    }

    public GameGrid getGrid(){
        return grid;
    }

    public void setSelectedPosition( int x , int y ){
        selectedPosX = x;
        selectedPosY = y;
    }

    public void setNumber( int number ){
        if( selectedPosX != -1 && selectedPosY != -1 ){
            grid.setItem(selectedPosX,selectedPosY,number);
        }
    }




}
