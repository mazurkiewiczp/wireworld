package generator;

public class Wireworld {
    private static int n = 400;
    private static int time = 250;

    public static void main(String[] args) {
        Cell[][] tab = new Cell[n][n];
        Cell[][] tmp = new Cell[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                tab[i][j]= new Cell(0,i,j);
                tmp[i][j]= new Cell(0,i,j);
            }
        }

        GUI gui = new GUI(n, tab, tmp);
        gui.GameTimer(time);
    }

}


