import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.TimerTask;

class MyTask extends TimerTask {

    public static int time = 300; // Le temps est en secondes 300s = 5 minutes
    final JFrame parent = new JFrame("Chronomètre"); // on créé une popup avec un titre
    JButton button = new JButton(); // on initialise un bouton

    public void run() {
        int minutes = (time % 3600) / 60;
        int seconds = time % 60;

        String timeString = String.format("%02d:%02d", minutes, seconds); // on set le format du temps minutes / secondes (00:00) 


        parent.add(button); // on ajoute le bouton
        button.setText(timeString); // dans le bouton on met notre timer
        parent.setSize(300, 200); // on régle la taille de la popup
        parent.setLocation(800, 400); // et sa possition
        parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // on fait en sorte que quand le bouton exit est enclanché alors on ferme le programme
        parent.setVisible(true); // on rent la popup visible

        time--; // on retire 1 a time

        
        if (time < 0) System.exit(0); // On quite le programme la fin du timer
    }
}

class Main {
    public static void main(final String[] args) {
        MyTask task = new MyTask();
        Timer timer = new Timer();

        timer.schedule(task, 0, 1000);
    }
}



