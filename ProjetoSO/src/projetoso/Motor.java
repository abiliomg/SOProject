/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoso;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author *Abílio - 8170054* | *Ricardo - 8170278* | *Vitor - 8170312*
 */
public class Motor implements Runnable {

    private int moving = 0; // 1 = mover para cima || -1 = mover para baixo
    private SharedOBJ sh1;
    Semaphore sem;

    public Motor(SharedOBJ sh) {
        this.sh1 = sh;
        this.sem = new Semaphore(1);
    }
    
    @Override
    public synchronized void run() {
        
        sh1.setMoving(true);
        if (sh1.getPisoS() > sh1.getCurrentFloor()) {
            movingUp();
        } else if (sh1.getPisoS() < sh1.getCurrentFloor()) {
            movingDown();
        }

    }

    public synchronized void movingUp() {
        while (sh1.getPisoS() != sh1.getCurrentFloor() ) {
            System.out.println(sh1.getCurrentFloor());
            sh1.setCurrentFloor(sh1.getCurrentFloor() + 1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Motor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        sh1.setMoving(false);
 
    }

    public synchronized void movingDown() {
        while (sh1.getPisoS() != sh1.getCurrentFloor()) {
            System.out.println(sh1.getCurrentFloor());
            sh1.setCurrentFloor(sh1.getCurrentFloor() - 1);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Motor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        sh1.setMoving(false);
    }

}
