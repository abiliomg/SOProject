/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoso;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicOptionPaneUI;

/**
 *
 * @author *Abílio - 8170054* | *Ricardo - 8170278* | *Vitor - 8170312*
 */
public class ProjetoSO implements ActionListener {

    private int pisoSelecionado;
    SharedOBJ sh1;
    private Motor mt;
    Portas pt;
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

    public ProjetoSO(SharedOBJ sh, Motor mt) {
        sh1 = sh;
        this.mt = mt;
        pt = new Portas(sh1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Semaphore sem = new Semaphore(1);
        boolean teste = true;
        SharedOBJ sh = new SharedOBJ();
        new Thread(new Display(sh)).start();
        new Thread(new Botoneira(sh)).start();

        /*
        Thread th2 = new Thread(new Motor(sh));

        th2.start();

        System.out.println(sh.getPisoS());

        try {
            th2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjetoSO.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int aux;

        if (e.getActionCommand() == "A") {
            new Thread(pt).start();

        } else if (e.getActionCommand() == "F") {
            if (queue.peek() == null) {

            } else {
                pt.setCommand("F");
                new Thread(pt).start();
                sh1.setPisoS(queue.poll());
                startMotor();
            }
        } else {

            System.out.println("Andar "
                    + ": " + e.getActionCommand());
            queue.add(Integer.parseInt(e.getActionCommand()));     
            startMotor();

        }
    }

    public void startMotor() {
   
        if(sh1.isDoorsOpen() == true){
            pt.setCommand("F");
            new Thread(pt).start();
        }
        new Thread(mt).start();
        mt.sendPisoS(queue);
   
    }

}
