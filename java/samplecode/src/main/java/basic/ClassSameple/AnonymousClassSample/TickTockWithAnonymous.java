package basic.ClassSameple.AnonymousClassSample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TickTockWithAnonymous {
    private String tickMessage = "Tick....";
    private String tockMessage = "Tock....";

    public static void main(String[] args) {
        TickTockWithAnonymous tickTockWithAnonymous = new TickTockWithAnonymous();

        tickTockWithAnonymous.go();

    }

    private void go() {
        // create a timer that call the Tick class
        // at one second intervals
        Timer timer = new Timer(1000, new ActionListener() {
            private boolean tick = true;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (tick) {
                    System.out.println(tickMessage);
                } else {
                    System.out.println(tockMessage);
                }
                tick = !tick;
            }
        });

        timer.start();
        // AirRoad a Message box to prevent the program from ending immediately
        JOptionPane.showMessageDialog(null, "Click OK to exit program.");
    }
}
