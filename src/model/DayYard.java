package model;

import in_game.Game;
import in_game.GameDay;
import javafx.scene.image.Image;

public class DayYard extends Yard {

    public DayYard( GameDay game) {
        super(game, false);
        this.background = new Image("/png/wallp.png");

    }


    private static final int YARD_X1 = 270;
    private static final int YARD_X2 = 1000;
    private static final int YARD_Y1 = 20;
    private static final int YARD_Y2 = 500;

    private static final int delta_x = (YARD_X2 - YARD_X1)/19;
    private static final int delta_y = (YARD_Y2 - YARD_Y1)/6;

    public static int getDelta_x() {
        return delta_x;
    }

    public static int getDelta_y() {
        return delta_y;
    }

    {
        int delta_x = (YARD_X2 - YARD_X1)/19;
        int delta_y = (YARD_Y2 - YARD_Y1)/6;
        for (int i = 0; i < 19; i++ ){
            for(int j = 0; j < 6; j++){
                if(i!=18 && j!= 5){
                    this.cells[i][j] = new Cell(true, YARD_X1 + delta_x*i
                            , YARD_X1 + delta_x*(i+1),YARD_Y1 + delta_y*j
                            ,YARD_Y1 + delta_y*(j+1));
                }
                else{
                    if(i == 18 && j!= 5){
                        this.cells[i][j] = new Cell(true, YARD_X1 + delta_x*i
                                , YARD_X2,YARD_Y1 + delta_y*j
                                ,YARD_Y1 + delta_y*(j+1));
                    }
                    else if(i!=18 && j==5){
                        this.cells[i][j] = new Cell(true, YARD_X1 + delta_x*i
                                , YARD_X1 + delta_x*(i+1),YARD_Y1 + delta_y*j
                                ,YARD_Y2);
                    }
                    else{
                        this.cells[i][j] = new Cell(true, YARD_X1 + delta_x*i
                                , YARD_X2,YARD_Y1 + delta_y*j
                                ,YARD_Y2);
                    }
                }

            }
        }
    }

    public static int[] whichCoordinateAmI(DayYard dayYard,double x,double y){
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
