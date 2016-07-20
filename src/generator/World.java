package generator;

public class World {
    private int n;
    private Cell tab[][];
    private Cell tmp[][];

    public World(int n, Cell[][] tab, Cell[][] tmp){
        this.n = n;
        this.tab = tab;
        this.tmp = tmp;
    }

    // 0 - pusta
    // 1 - głowa
    // 2 - ogon
    // 3 - przewodnik

    void next(){
        for (int i=1; i<n-1; i++){
            for (int j=1; j<n-1; j++){
                if (tmp[i][j].getState()==0) continue;
                if (tmp[i][j].getState()==1) {tab[i][j].state=2; continue;}
                if (tmp[i][j].getState()==2) {tab[i][j].state=3; continue;}
                if (tmp[i][j].getState()==3 && getNeighbors(tmp[i][j].getX(),tmp[i][j].getY())==1){ tab[i][j].state=1; continue;}
                if (tmp[i][j].getState()==3 && getNeighbors(tmp[i][j].getX(),tmp[i][j].getY())==2) tab[i][j].state=1;
            }
        }
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                tmp[i][j].state=tab[i][j].state;
            }
        }
    }

    int getNeighbors(int x, int y){
        int s=0;
        if (tmp[x-1][y-1].getState()==1) s++;
        if (tmp[x][y-1].getState()==1) s++;
        if (tmp[x+1][y-1].getState()==1) s++;
        if (tmp[x-1][y].getState()==1) s++;
        if (tmp[x+1][y].getState()==1) s++;
        if (tmp[x-1][y+1].getState()==1) s++;
        if (tmp[x][y+1].getState()==1) s++;
        if (tmp[x+1][y+1].getState()==1) s++;
        return s;
    }
}