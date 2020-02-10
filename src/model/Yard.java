package model;

import in_game.Game;
import javafx.scene.image.Image;

public abstract class Yard {
    double width;
    double height;
    Image background;
    Cell[][] cells = new Cell[6][19];
    private Game game;
    private boolean isItWater;
    private static final int delta_x = 0;
    private static final int delta_y = 0;
    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Yard(Game game, boolean isItWater) {
        this.game = game;
        this.isItWater = isItWater;
    }

    public Game getGame() {
        return game;
    }

    public Image getBackground() {
        return background;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public boolean isItWater() {
        return isItWater;
    }


    public static int getDelta_x() {
        return delta_x;
    }

    public static int getDelta_y() {
        return delta_y;
    }

    public static int[] whichCoordinateAmI(Yard dayYard,double x,double y){
        int i = 0;
        int j = 0;
        for(j = 0; j < 6; j++){
            for(i = 0; i < 19; i++){
                if(dayYard.cells[i][j].getX1() <= x && dayYard.cells[i][j].getX2() >= x
                        && dayYard.cells[i][j].getY1() <= y && dayYard.cells[i][j].getY2() >= y){
                    int[] ans = new int[2];
                    ans[1] = i + 1;
                    ans[2] = j + 1;
                    return ans;
                }
            }
        }
        return null;
    }

    public static Cell whichCellAmI(DayYard dayYard,double x,double y){
        int i = 0;
        int j = 0;
        for(j = 0; j < 6; j++){
            for(i = 0; i < 19; i++){
                if(dayYard.cells[i][j].getX1() <= x && dayYard.cells[i][j].getX2() >= x
                        && dayYard.cells[i][j].getY1() <= y && dayYard.cells[i][j].getY2() >= y){
                    return dayYard.cells[i][j];
                }
            }
        }
        return null;
    }


    public static int[] whichPixelAmI(Cell cell){
        int x = (cell.getX1() + cell.getX2())/2 ;
        int y = (cell.getY1() + cell.getY2())/2;
        int res[] = new int[2];
        res[0] = x;
        res[1] = y;
        return res;
    }





}
