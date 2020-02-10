package model;

import in_game.Game;
import in_game.GameDay;
import javafx.scene.image.Image;

public class DayYard extends Yard {

    public DayYard(GameDay game) {
        super(game, false);
        this.background = new Image("/png/wallp.png");

    }


    private static final int YARD_X1 = 270;
    private static final int YARD_X2 = 1000;
    private static final int YARD_Y1 = 20;
    private static final int YARD_Y2 = 500;

    private static final int delta_x = (YARD_X2 - YARD_X1) / 19;
    private static final int delta_y = (YARD_Y2 - YARD_Y1) / 6;

    public static int getDelta_x() {
        return delta_x;
    }

    public static int getDelta_y() {
        return delta_y;
    }

    {
        int delta_x = (YARD_X2 - YARD_X1) / 19;
        int delta_y = (YARD_Y2 - YARD_Y1) / 6;
        for (int j = 0; j < 19; j++) {
            for (int i = 0; i < 6; i++) {
                System.out.println("i is " + i + " j is ");
                cells[i][j] = new Cell(true, 1, 1, 1, 1);
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 19; j++) {
                if (j != 18 && i != 5) {
                    this.cells[i][j] = new Cell(true, YARD_X1 + delta_x * j
                            , YARD_X1 + delta_x * (j + 1), YARD_Y1 + delta_y * i
                            , YARD_Y1 + delta_y * (i + 1));
                } else {
                    if (j == 18 && i != 5) {
                        this.cells[i][j] = new Cell(true, YARD_X1 + delta_x * j
                                , YARD_X2, YARD_Y1 + delta_y * i
                                , YARD_Y1 + delta_y * (i + 1));
                    } else if (j != 18 && i == 5) {
                        this.cells[i][j] = new Cell(true, YARD_X1 + delta_x * j
                                , YARD_X1 + delta_x * (j + 1), YARD_Y1 + delta_y * i
                                , YARD_Y2);
                    } else {
                        this.cells[i][j] = new Cell(true, YARD_X1 + delta_x * j
                                , YARD_X2, YARD_Y1 + delta_y * i
                                , YARD_Y2);
                    }
                }

            }
        }
    }

    public static int[] whichCoordinateAmI(DayYard dayYard, double x, double y) {
        int i = 0;
        int j = 0;
        for (i = 0; i < 6; i++) {
            for (j = 0; j < 19; j++) {
                if (dayYard.cells[i][j].getX1() <= x && dayYard.cells[i][j].getX2() >= x
                        && dayYard.cells[i][j].getY1() <= y && dayYard.cells[i][j].getY2() >= y) {
                    int[] ans = new int[2];
                    ans[0] = j ;
                    ans[1] = i ;
                    return ans;
                }
            }
        }
        return null;
    }

    public static Cell whichCellAmI(DayYard dayYard, double x, double y) {
        int i = 0;
        int j = 0;
        for (i = 0; i < 6; i++) {
            for (j= 0; j < 19; j++) {
                if (dayYard.cells[i][j].getX1() <= x && dayYard.cells[i][j].getX2() >= x
                        && dayYard.cells[i][j].getY1() <= y && dayYard.cells[i][j].getY2() >= y) {
                    return dayYard.cells[i][j];
                }
            }
        }
        return null;
    }


    public static int[] whichPixelAmI(Cell cell) {
        if (cell != null){
            int x = (cell.getX1() + cell.getX2()) / 2;

            int y = (cell.getY1() + cell.getY2()) / 2;
            int res[] = new int[2];
            res[0] = x;
            res[1] = y;
            return res;
        }
        int[] res = new int[2];
        res[0] = 1;
        res[1] = 1;
        return res;
    }

}
