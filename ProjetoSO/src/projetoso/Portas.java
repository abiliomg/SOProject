/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoso;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author *Abílio - 8170054* | *Ricardo - 8170278* | *Vitor - 8170312*
 */
public class Portas implements Runnable {

    String command;
    SharedOBJ sh1;

    public Portas(SharedOBJ sh) {
        this.command = command;
        this.sh1 = sh;

    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public void run() {
        if (this.command == "F") {
            closeDoors();
        } else if (this.command == "A") {
            openDoors();
        }

        while(true){
            if (!sh1.isMoving()){
                openDoors();
            }
        }
    }

    public void openDoors() {
        sh1.setDoorsOpen(true);
    }

    public void closeDoors() {
        sh1.setDoorsOpen(false);

    }

}
