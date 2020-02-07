package model;

import in_game.Game;
import javafx.scene.image.Image;

public class DayYard extends Yard {

    public DayYard( Game game) {
        super(game, false);
        this.background = new Image("/png/wallp.png");

    }

    private final int YARD_X1 = 270;
    private final int YARD_X2 = 1000;
    private final int YARD_Y1 = 20;
    private final int YARD_Y2 = 500;

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

    public int[] whichCellAmI(double x,double y){
        int i = 0;
        int j = 0;
        for(j = 0; j < 6; j++){
            for(i = 0; i < 19; i++){
                if(this.cells[i][j].getX1() <= x && this.cells[i][j].getX2() >= x
                && this.cells[i][j].getY1() <= y && this.cells[i][j].getY2() >= y){
                    int[] ans = new int[2];
                    ans[1] = i + 1;
                    ans[2] = j + 1;
                    return ans;
                }
            }
        }
        return null;
    }

}
