/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoso;

/**
 *
 * @author Ricardo
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Display implements Runnable {

    private SharedOBJ sh1;

    public Display(SharedOBJ sh) {
        this.sh1 = sh;
    }

    @Override
    public void run() {
        JFrame teste = new JFrame();
        teste.setSize(200, 300);

        JPanel panel = new JPanel();
        GridLayout grid = new GridLayout(2,2);
        panel.setLayout(grid);
        teste.add(panel);
        JLabel dis = new JLabel("" + sh1.getCurrentFloor());
        JLabel door = new JLabel("Teste");
        panel.add(dis);
        panel.add(door);
        teste.setLocation(1920 / 2 + 185, 1080 / 2 - 150);
        dis.setBounds(0, 0, 50, 50);
        door.setBounds(100, 100, 50, 50);
        teste.setVisible(true);

        while (true) {

            dis.setText("  Andar Atual: "+ sh1.getCurrentFloor());
            door.setText("  Estado da Porta: " + sh1.isDoorsOpen());
            if (Thread.interrupted()) {
                return;
            }
        }

    }

}
