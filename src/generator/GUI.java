package generator;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import java.awt.FileDialog;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GUI{
    private World w;

    public GUI(int n, Cell[][] tab, Cell[][] tmp) {

        JFrame frame = new JFrame("Wireworld");

        FileDialog fd = new FileDialog(frame,"Wczytaj",FileDialog.LOAD);
        fd.setVisible(true);
        String katalog = fd.getDirectory();
        String plik = fd.getFile();
        LoadWorld(katalog + plik, n, tab, tmp);

        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Board(n,tab));
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(n,n);
        w = new World(n,tab,tmp);
    }

    private void LoadWorld(String path, int n, Cell[][] tab, Cell[][] tmp){
        FileInputStream fis = null;

        try {
            fis = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku!");
            System.exit(1);
        }

        int b = 0;
        int xs=0, ys=0;

        try {
            b = fis.read();

            while(b != -1){
                if (b == 48){
                    xs++;
                    if (xs>n/5){xs=1; ys++;}
                }
                if (b == 49){
                    tab[ys][xs].state=1;
                    tmp[ys][xs].state=1;
                    xs++;
                    if (xs>n/5){xs=1; ys++;}
                }
                if (b == 50){
                    tab[ys][xs].state=2;
                    tmp[ys][xs].state=2;
                    xs++;
                    if (xs>n/5){xs=1; ys++;}
                }
                if (b == 51){
                    tab[ys][xs].state=3;
                    tmp[ys][xs].state=3;
                    xs++;
                    if (xs>n/5){xs=1; ys++;}
                }
                b = fis.read();
                if (ys==n/5) break;
            }
        } catch (IOException e) {
            System.out.println("Błąd przy odczycie pliku!");
            System.exit(2);
        }

        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void GameTimer(int time) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                w.next();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task,0,time);
    }

}