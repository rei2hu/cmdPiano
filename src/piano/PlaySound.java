/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

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
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);
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
