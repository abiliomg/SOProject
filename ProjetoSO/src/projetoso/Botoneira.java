/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoso;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author *Abílio - 8170054* | *Ricardo - 8170278* | *Vitor - 8170312*
 */
class Action implements ActionListener {

    private int pisoSelecionado;
    SharedOBJ sh1;
    private Motor mt;
    Semaphore sem;

    public Action(SharedOBJ sh, Motor mt) {
        sh1 = sh;
        sem = new Semaphore(1);
        this.mt = mt;
    }

    public void actionPerformed(ActionEvent e) {

        System.out.println("Por favor:" + e.getActionCommand());
        sh1.setPisoS(Integer.parseInt(e.getActionCommand()));
        sh1.setBtPressed(false);

        /*
        try {
            sem.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Action.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread(new Motor(sh1)).start();

        if (sh1.getCurrentFloor() == Integer.parseInt(e.getActionCommand())) {
            sem.release();
        }
         */
    }

    public int getPisoS() {
        return this.pisoSelecionado;
    }
}

public class Botoneira implements Runnable {

    private int pisoS;
    private Action teste;
    private JButton[] aux;
    private SharedOBJ sh1;
    private Motor mt;

    public Botoneira(SharedOBJ sh) {
        sh1 = sh;
        FileManager fm = new FileManager();
        mt = new Motor(sh1);
        int i = 0, piso, gridHelper;
        ProjetoSO act = new ProjetoSO(sh1, mt);

        //Ler ficheiro com o número de andares e peso máximo
        fm.readFile("elevador.txt");
        JPanel panela = new JPanel();
        Dimension panelDimension = new Dimension(300, 300);
        if (fm.getPisos() % 2 == 0) {
            gridHelper = fm.getPisos() / 2;
        } else {
            gridHelper = (fm.getPisos() + 1) / 2;
        }
        panela.setLayout(new GridLayout(3 + gridHelper, 2));

        panela.setSize(panelDimension);
        panela.setMaximumSize(panelDimension);
        Dimension frameDimension = new Dimension(400, 300);

        JFrame elevador = new JFrame("Elevador");

        //Definir tamanho da janela e localização inicial
        elevador.setSize(frameDimension);
        elevador.setMaximumSize(frameDimension);
        elevador.setLocation(1920 / 2 - 200, 1080 / 2 - 150);

        // Construtor do label que apresenta o andar atual
        JLabel elevadorSign = new JLabel("");
        elevadorSign.setHorizontalAlignment(SwingConstants.LEFT);
        panela.add(elevadorSign);
        elevadorSign.setSize(30,70);
        JLabel andarMostrar = new JLabel("Bem-vindo ao elevador pressione um botão com o andar que pretende, e de seguida, feche a porta");
        panela.add(andarMostrar);
        JButton[] bt = new JButton[fm.getPisos()];
        JButton fechar = new JButton("Fechar");
        fechar.setActionCommand("F");
        fechar.addActionListener(act);
        JButton abrir = new JButton("Abrir");
        abrir.setActionCommand("A");
        abrir.addActionListener(act);
        Dimension buttonDimension = new Dimension(10, 10);
        JLabel clear = new JLabel(" ");
        JLabel clear2 = new JLabel(" ");
        JLabel clear3 = new JLabel(" ");
        
        //Ciclo que acrecenta botões dependendo do número de andares definido 
        while (i < fm.getPisos()) {
            piso = i;
            bt[i] = new JButton("" + piso);
            bt[i].setSize(10, 10);
            bt[i].setMaximumSize(buttonDimension);
            bt[i].setActionCommand("" + i);
            bt[i].addActionListener(act);
            panela.add(bt[i]);
            i++;
        }
        if (fm.getPisos() % 2 == 0) {
            panela.add(clear);
            panela.add(clear2);
        } else {
            panela.add(clear);
            panela.add(clear2);
            panela.add(clear3);
        }

        panela.add(fechar);
        panela.add(abrir);
        elevador.add(panela);
        elevador.setBackground(Color.GREEN);
        elevador.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        elevador.setVisible(true);

        System.out.println(fm.getCarga());
        System.out.println(fm.getPisos());
        aux = bt;

    }

    public void setPisoS(int pisoS) {

    }

    public int getPisoS() {
        return this.pisoS;
    }

    @Override
    public void run() {
        System.out.println("Running");
    }

}
