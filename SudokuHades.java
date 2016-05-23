package com.example.sadeqnairat.watashinosudoko;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mohammad Sadeq Nairat on 5/21/2016.
 */
public class SudokuHades {

    private class Point{
        int x,y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }


    private static SudokuHades instance;
    private ArrayList<ArrayList<Integer>> validInputs
            = new ArrayList<ArrayList<Integer>>();

    private Random rand = new Random();

    private SudokuHades(){

    }

    public static SudokuHades getInstance(){
        if(instance == null)
            instance = new SudokuHades();
        return instance;
    }

    public int [][] conjureSudoko(){
        int[][] sudoko = new int[9][9];

        int current = 0;


        while( current < 81 ){
            if( current == 0 ){
                validInputs.clear();

                for( int y =  0; y < 9 ; y++ ){
                    for( int x = 0 ; x < 9 ; x++ ){
                        sudoko[x][y] = -1;
                    }
                }

                for( int x = 0 ; x < 81 ; x++ ){
                    validInputs.add(new ArrayList<Integer>());
                    for( int i = 1 ; i <= 9 ; i++){
                        validInputs.get(x).add(i);
                    }
                }
            }

            if( validInputs.get(current).size() != 0 ){
                int i = rand.nextInt(validInputs.get(current).size());
                int number = validInputs.get(current).get(i);

                if( validMove(sudoko, current , number)){
                    int x = current % 9;
                    int y = current / 9;

                    sudoko[x][y] = number;

                    validInputs.get(current).remove(i);

                    current++;
                }else{
                    validInputs.get(current).remove(i);
                }

            }else{
                for( int i = 1 ; i <= 9 ; i++ ){
                    validInputs.get(current).add(i);
                }
                current--;
            }
        }


        return sudoko;
    }
    public int [][] conjureUnDoneSudoko(){
        int[][] sudoko = new int[9][9];

        int current = 0;


        while( current < 81 ){
            if( current == 0 ){
                validInputs.clear();

                for( int y =  0; y < 9 ; y++ ){
                    for( int x = 0 ; x < 9 ; x++ ){
                        sudoko[x][y] = -1;
                    }
                }

                for( int x = 0 ; x < 81 ; x++ ){
                    validInputs.add(new ArrayList<Integer>());
                    for( int i = 1 ; i <= 9 ; i++){
                        validInputs.get(x).add(i);
                    }
                }
            }

            if( validInputs.get(current).size() != 0 ){
                int i = rand.nextInt(validInputs.get(current).size());
                int number = validInputs.get(current).get(i);

                if( validMove(sudoko, current , number)){
                    int x = current % 9;
                    int y = current / 9;

                    sudoko[x][y] = number;

                    validInputs.get(current).remove(i);

                    current++;
                }else{
                    validInputs.get(current).remove(i);
                }

            }else{
                for( int i = 1 ; i <= 9 ; i++ ){
                    validInputs.get(current).add(i);
                }
                current--;
            }
        }

        int i = 0;

        while( i < 33 ){
            int x = rand.nextInt(9);
            int y = rand.nextInt(9);

            if( sudoko[x][y] != 0 ){
                sudoko[x][y] = 0;
                i++;
            }
        }
        return sudoko;
    }


    private boolean validMove(int[][] sudoko , int current , int number){
        int x = current % 9;
        int y = current / 9;
        Point p = new Point(x,y);

        if( !validHorizontal(sudoko, p, number) ||
                !validVertical(sudoko, p, number) ||
                      !validSquare(sudoko, p , number) ){
            return false;
        }

        return true;
    }

    private boolean validHorizontal(int[][] sudoko , Point p , int number ){
        for( int x = p.x - 1; x >= 0 ; x-- ){
            if( number == sudoko[x][p.y]){
                return false;
            }
        }

        return true;
    }

    private boolean validVertical(int[][] sudoko , Point p , int number ){
        for( int y = p.y - 1; y >= 0 ; y-- ){
            if( number == sudoko[p.x][y] ){
                return false;
            }
        }

        return true;
    }

    private boolean validSquare(int[][] sudoko , Point p , int number ){
        int xStart = (p.x / 3) * 3;
        int yStart = (p.y / 3) * 3;
        int xEnd = (p.x / 3) * 3 + 3;
        int yEnd = (p.y / 3) * 3 + 3;

        for( int x = xStart ; x < xEnd ; x++ ){
            for( int y = yStart * 3 ; y < yEnd; y++ ){
                if( ( x != p.x || y != p.y ) && number == sudoko[x][y] ){
                    return false;
                }
            }
        }

        return true;
    }


}
