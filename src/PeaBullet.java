import Model.Cell;

public class PeaBullet {
    private int x;
    private int y;
    Cell cell ;


    public void shoot(int x,int y){
        cell=new Cell(x,y);
    }
    public void move(){
        cell=new Cell(x+1,y);
    }
}
