package generator;

public class Cell {
    public int state;
    private int x;
    private int y;

    public Cell(int state, int x, int y){
        this.state = state;
        this.x = x;
        this.y = y;
    }

    int getState(){
        return state;
    }

    int getX(){
        return x;
    }

    int getY(){
        return y;
    }
}