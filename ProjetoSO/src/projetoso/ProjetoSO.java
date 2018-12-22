/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoso;

import javax.swing.*;
import java.awt.*;

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

        int i = 0,piso,gridHelper;
        
        //Ler ficheiro com o número de andares e peso máximo
        FileManager fm = new FileManager();
        fm.readFile("elevador.txt");
        JPanel panela = new JPanel();
        Dimension panelDimension=new Dimension(300,300);
        if(fm.getPisos()%2==0){
            gridHelper=fm.getPisos()/2;
        }else{
            gridHelper=(fm.getPisos()+1)/2;
        }
        panela.setLayout(new GridLayout(3+gridHelper, 2));
        
        panela.setSize(panelDimension);
        panela.setMaximumSize(panelDimension);
        Dimension frameDimension=new Dimension(400,300);
        
        JFrame elevador = new JFrame("Elevador");
        //Definir tamanho da janela e localização inicial
        elevador.setSize(frameDimension);
        elevador.setMaximumSize(frameDimension);
        elevador.setLocation(1920 / 2 - 400, 1080 / 2 - 300);
        // Construtor do label que apresenta o andar atual
        JLabel andarAtual = new JLabel("Andar atual: ");
        andarAtual.setHorizontalAlignment(SwingConstants.RIGHT);
        panela.add(andarAtual);
        andarAtual.setSize(30, 30);
        JLabel andarMostrar=new JLabel(""+1);
        panela.add(andarMostrar);
        //Ciclo que acrecenta botões dependendo do número de andares definido
        JButton[] bt = new JButton[fm.getPisos()];
        JButton fechar=new JButton("Fechar");
        JButton abrir=new JButton("Abrir");
        Dimension buttonDimension=new Dimension(10,10);
        JLabel clear=new JLabel(" ");
        JLabel clear2=new JLabel(" ");
        JLabel clear3=new JLabel(" ");
        while (i < fm.getPisos()) {
            piso=i+1;
            bt[i] = new JButton(""+piso);
            bt[i].setSize( 10, 10);
            bt[i].setMaximumSize(buttonDimension);
            panela.add(bt[i]);
            i++;
        }
        if(fm.getPisos()%2==0){
            panela.add(clear);
        panela.add(clear2);
        }else{
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
        
    }

}

