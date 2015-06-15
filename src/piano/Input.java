/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.String;

/**
 *
 * @author Thomas
 */

public class Input implements Runnable{
    
    DataInputStream in;
    
    public Input(DataInputStream in){
        this.in = in;
    }
    
    public void run(){
        
        
        while(true){
            try{
                //splits the "message" into individual letters and then plays notes based on those letters
                
                String message = in.readUTF();
                File note = new File("");
                
                //message printing, can avoid printing with commented statement
                //if message minus (name length), minus 3 characters representing
                // : colon
                //   space between colon and message
                // 3 represents name length
                //is greater than 1, then print.
                //because message always starts with . it should be ok
                //
                if ((message.startsWith("6Server")) == true){
                    System.out.println(message.substring(1));
                    PianoGUI.chatBox2.append(message.substring(1) + "\n");
                    continue;
                }else if ((message.substring(3 + Integer.parseInt(message.substring(0,1))).startsWith(".")) == true){
                    message = message.substring(0, 3 + Integer.parseInt(message.substring(0,1))) + message.substring(4 + Integer.parseInt(message.substring(0,1)));
                    PianoGUI.chatBox2.append(message.substring(1) + "\n");
                    continue;
                }
                
                
//                if(message.startsWith("6Server:") == true ){
//                    continue;
//                }else 
                
                
                //note: for sounds to play you need folders in same directory as
                //jar file when compiled or something
                
                //clap command (//) from client to server to client
                
                if(message.endsWith("/") == true){
                    note = new File("./soundeffects/applause.wav");
                        PlaySound Playsound = new PlaySound(note);
                        Thread PlaySound = new Thread(Playsound);
                        PlaySound.start();
                        note = null;
                    continue;
                    
                //cricket command (\\) from client to server to client
                    
                }else if(message.endsWith("\\") == true){
                    note = new File("./soundeffects/cricket.wav");
                        PlaySound Playsound = new PlaySound(note);
                        Thread PlaySound = new Thread(Playsound);
                        PlaySound.start();
                        note = null;
                    continue;
                }
                
                //chat messages (begin with .) from client to server to client
                //dont play any sound
                //might not be necessary: lines 123-125 skip if message is longer than 1
                    
//                }else if (message.startsWith(".") == true){
//                    continue;
//                }
                
                //this is the main note playing section
                //1 2 3 4 5 6 7 8 9 0
                //q w e r t y u i o p
                //a s d f g h j k l
                //z x c v b n m
                
                //! @ $ % ^ * (
                //Q W E T Y I O P
                //S D G H J L Z
                //C V B
                
                //61 notes total
                
                for (int i = Integer.parseInt(message.substring(0, 1)) + 3; i < message.length(); i++){
                    String key = Character.toString(message.charAt(i));
                    switch(key){
                        case "1":
                                note = new File("./current/a1.wav");
                                break;
                        case "2":
                                note = new File("./current/a2.wav");
                                break;
                        case "3":
                                note = new File("./current/a3.wav");
                                break;
                        case "4":
                                note = new File("./current/a4.wav");
                                break;
                        case "5":
                                note = new File("./current/a5.wav");
                                break;
                        case "6":
                                note = new File("./current/a6.wav");
                                break;
                        case "7":
                                note = new File("./current/a7.wav");
                                break;
                        case "8":
                                note = new File("./current/a8.wav");
                                break;
                        case "9":
                                note = new File("./current/a9.wav");
                                break;
                        case "0":
                                note = new File("./current/a10.wav");
                                break;
                        case "q":
                                note = new File("./current/a11.wav");
                                break;
                        case "w":
                                note = new File("./current/a12.wav");
                                break;
                        case "e":
                                note = new File("./current/a13.wav");
                                break;
                        case "r":
                                note = new File("./current/a14.wav");
                                break;
                        case "t":
                                note = new File("./current/a15.wav");
                                break;
                        case "y":
                                note = new File("./current/a16.wav");
                                break;
                        case "u":
                                note = new File("./current/a17.wav");
                                break;
                        case "i":
                                note = new File("./current/a18.wav");
                                break;
                        case "o":
                                note = new File("./current/a19.wav");
                                break;
                        case "p":
                                note = new File("./current/a20.wav");
                                break;
                        case "a":
                                note = new File("./current/a21.wav");
                                break;
                        case "s":
                                note = new File("./current/a22.wav");
                                break;
                        case "d":
                                note = new File("./current/a23.wav");
                                break;
                        case "f":
                                note = new File("./current/a24.wav");
                                break;
                        case "g":
                                note = new File("./current/a25.wav");
                                break;
                        case "h":
                                note = new File("./current/a26.wav");
                                break;
                        case "j":
                                note = new File("./current/a27.wav");
                                break;
                        case "k":
                                note = new File("./current/a28.wav");
                                break;
                        case "l":
                                note = new File("./current/a29.wav");
                                break;
                        case "z":
                                note = new File("./current/a30.wav");
                                break;
                        case "x":
                                note = new File("./current/a31.wav");
                                break;
                        case "c":
                                note = new File("./current/a32.wav");
                                break;
                        case "v":
                                note = new File("./current/a33.wav");
                                break;
                        case "b":
                                note = new File("./current/a34.wav");
                                break;
                        case "n":
                                note = new File("./current/a35.wav");
                                break;
                        case "m":
                                note = new File("./current/a36.wav");
                                break;
                        case "!":
                                note = new File("./current/b1.wav");
                                break;
                        case "@":
                                note = new File("./current/b2.wav");
                                break;
                        case "$":
                                note = new File("./current/b3.wav");
                                break;
                        case "%":
                                note = new File("./current/b4.wav");
                                break;
                        case "^":
                                note = new File("./current/b5.wav");
                                break;
                        case "*":
                                note = new File("./current/b6.wav");
                                break;
                        case "(":
                                note = new File("./current/b7.wav");
                                break;
                        case "Q":
                                note = new File("./current/b8.wav");
                                break;
                        case "W":
                                note = new File("./current/b9.wav");
                                break;
                        case "E":
                                note = new File("./current/b10.wav");
                                break;
                        case "T":
                                note = new File("./current/b11.wav");
                                break;
                        case "Y":
                                note = new File("./current/b12.wav");
                                break;
                        case "I":
                                note = new File("./current/b13.wav");
                                break;
                        case "O":
                                note = new File("./current/b14.wav");
                                break;
                        case "P":
                                note = new File("./current/b15.wav");
                                break;
                        case "S":
                                note = new File("./current/b16.wav");
                                break;
                        case "D":
                                note = new File("./current/b17.wav");
                                break;
                        case "G":
                                note = new File("./current/b18.wav");
                                break;
                        case "H":
                                note = new File("./current/b19.wav");
                                break;
                        case "J":
                                note = new File("./current/b20.wav");
                                break;
                        case "L":
                                note = new File("./current/b21.wav");
                                break;
                        case "Z":
                                note = new File("./current/b22.wav");
                                break;   
                        case "C":
                                note = new File("./current/b23.wav");
                                break;
                        case "V":
                                note = new File("./current/b24.wav");
                                break;
                        case "B":
                                note = new File("./current/b25.wav");
                                break;
                        default:
                                continue;
                    }
                        PlaySound Playsound = new PlaySound(note);
                        Thread PlaySound = new Thread(Playsound);
                        PlaySound.start();
                        note = null;
                }
            }catch (IOException e){
            }
        }
    }

    //wav playing
    
//    public static void PlaySound(File Sound){
//        try
//        {
//            Clip clip = AudioSystem.getClip();
//            clip.open(AudioSystem.getAudioInputStream(Sound));
//            clip.start();
//        }
//        catch (Exception exc)
//        {
//            exc.printStackTrace(System.out);
//        }
//    }
}
