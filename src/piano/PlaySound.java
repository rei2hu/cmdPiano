/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;

/**
 *
 * @author Thomas
 */

class PlaySound implements Runnable{
    
    File file;
    
    public PlaySound(File file){
        this.file = file;
    }
    
    public void run(){
        try{
            Clip clip = AudioSystem.getClip();
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            clip.open(stream);
            stream = null;
            clip.start();
            Thread.sleep(1800);
            clip.stop();
            clip.close();
//            clip.addLineListener(new LineListener() {
//                public void update(LineEvent myLineEvent) {
//                    if (myLineEvent.getType() == LineEvent.Type.STOP){
//                        clip.close();                    
//                    }
//                }
//            });   
        }
        catch (Exception e){
            
        }
    }

}
