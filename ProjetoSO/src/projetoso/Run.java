/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoso;

/**
 *
 * @author Dumbr
 */
public class Run implements Runnable{
    private SharedOBJ share;
    
    
    public Run(SharedOBJ share) {
        this.share = share;
    }
    
    

    @Override
    public void run() {
        System.out.println("Hello from a thread");
    }
    
}
