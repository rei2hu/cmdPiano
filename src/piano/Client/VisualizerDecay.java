/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano.Client;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thomas
 */

public class VisualizerDecay implements Runnable{
    
    static int a;
    
    public VisualizerDecay(int a){
        this.a = a;
    }
    
    public void run(){
        
        try{
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            
        }
        
        while(true){
            
            if(a > 0){
                a--;
            }
            try{
                Thread.sleep(50);
            } catch (InterruptedException e) {
                
            }
            PianoClientGUI.jProgressBar1.setValue(a);
        }
    }
    
}
