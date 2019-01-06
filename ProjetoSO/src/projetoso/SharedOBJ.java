/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoso;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Dumbr
 */
public class SharedOBJ {

    Semaphore semP = new Semaphore(1);
    private int currentFloor;
    private int pisoS;
    private boolean btPressed;
    private boolean moving = false;
    private boolean doorsOpen = true;
    private int carga = 0;
    private int maxCarga;

    public int getMaxCarga() {
        return maxCarga;
    }

    public void setMaxCarga(int maxCarga) {
        this.maxCarga = maxCarga;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        if (this.carga + carga >= 0) {
            this.carga = this.carga + carga;
        }
    }

    public boolean isDoorsOpen() {
        return doorsOpen;
    }

    public void setDoorsOpen(boolean doorsOpen) {
        this.doorsOpen = doorsOpen;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public SharedOBJ() {
        this.btPressed = true;
    }

    public boolean isBtPressed() {
        return btPressed;
    }

    public void setBtPressed(boolean btPressed) {
        this.btPressed = btPressed;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getPisoS() {
        return pisoS;
    }

    public void setPisoS(int pisoS) {
        this.pisoS = pisoS;
    }

}
