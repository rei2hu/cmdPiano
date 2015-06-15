/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.IOException;
import java.awt.Dimension;

/**
 *
 * @author Thomas
 */

public class NoteListener implements Runnable{
    
    String[] keyNotes = {"1","2","3","4","5","6","7","8","9","0","q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m","!","@","$","%","^","*","(","Q","W","E","T","Y","I","O","P","S","D","G","H","J","L","Z","C","V","B"};
    Color color;
 
    public NoteListener(Color color){
        this.color = color;
    }
    
    public void run(){
        
          
                        
//                        //updates
//                        PianoGUI.panel1.setBackground(new Color(0,0,_1));
//                        PianoGUI.panel2.setBackground(new Color(0,0,_2));
//                        PianoGUI.panel3.setBackground(new Color(0,0,_3));
//                        PianoGUI.panel4.setBackground(new Color(0,0,_4));
//                        PianoGUI.panel5.setBackground(new Color(0,0,_5));
//                        PianoGUI.panel6.setBackground(new Color(0,0,_6));
//                        PianoGUI.panel7.setBackground(new Color(0,0,_7));
//                        PianoGUI.panel10.setBackground(new Color(0,0,_8));
//                        PianoGUI.panel11.setBackground(new Color(0,0,_9));
//                        PianoGUI.panel12.setBackground(new Color(0,0,_10));
//                        PianoGUI.panel15.setBackground(new Color(0,0,_11));
//                        PianoGUI.panel16.setBackground(new Color(0,0,_12));
//                        PianoGUI.panel18.setBackground(new Color(0,0,_13));
//                        //
    }
}
  
