/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoso;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.GridLayout;

/**
 *
 * @author *Abílio - 8170054* | *Ricardo - 8170278* | *Vitor - 8170312*
 */
public class ProjetoSO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int i = 0;

        FileManager fm = new FileManager();

        fm.readFile("elevador.txt");

        JFrame elevador = new JFrame("Elevador");
        JPanel panela = new JPanel();
       // elevador.setLayout(new GridLayout(2, 2));
        panela.setLayout(new GridLayout(2, 2));
        panela.setSize(200, 350);
        
        elevador.setSize(400, 700);
        elevador.setLocation(1920 / 2 - 200, 1080 / 2 - 350);
        JButton[] bt = new JButton[fm.getPisos()];
        while (i < fm.getPisos()) {
            bt[i] = new JButton("" + i);
            bt[i].setBounds(0, i * 75, 70, 70);
            panela.add(bt[i]);
            i++;
        }
        
        elevador.add(panela);
        elevador.setBackground(Color.yellow);
        elevador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        elevador.setVisible(true);

        System.out.println(fm.getCarga());
        System.out.println(fm.getPisos());

    }

}
