/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import static piano.PianoGUI.pianoArea;

/**
 *
 * @author Thomas
 */

public class Input implements Runnable{
    
    String[] keyNotes = {"1","2","3","4","5","6","7","8","9","0","q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m","!","@","$","%","^","*","(","Q","W","E","T","Y","I","O","P","S","D","G","H","J","L","Z","C","V","B"};
    
    int _1, _2, _3, _4, _5, _6, _7, _8 ,_9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21, _22, _23, _24 ,_25, _26, _27, _28, _29, _30, _31, _32, _33, _34, _35, _36;
    
    File[] fileLocations = {new File("./current/a1.wav"),new File("./current/a2.wav"),new File("./current/a3.wav"),new File("./current/a4.wav"),new File("./current/a5.wav"),
                            new File("./current/a6.wav"),new File("./current/a7.wav"),new File("./current/a8.wav"),new File("./current/a9.wav"),new File("./current/a10.wav"),
                            new File("./current/a11.wav"),new File("./current/a12.wav"),new File("./current/a13.wav"),new File("./current/a14.wav"),new File("./current/a15.wav"),
                            new File("./current/a16.wav"),new File("./current/a17.wav"),new File("./current/a18.wav"),new File("./current/a19.wav"),new File("./current/a20.wav"),
                            new File("./current/a21.wav"),new File("./current/a22.wav"),new File("./current/a23.wav"),new File("./current/a24.wav"),new File("./current/a25.wav"),
                            new File("./current/a26.wav"),new File("./current/a27.wav"),new File("./current/a28.wav"),new File("./current/a29.wav"),new File("./current/a30.wav"),
                            new File("./current/a31.wav"),new File("./current/a32.wav"),new File("./current/a33.wav"),new File("./current/a34.wav"),new File("./current/a35.wav"),
                            new File("./current/a36.wav"),new File("./current/b1.wav"),new File("./current/b2.wav"),new File("./current/b3.wav"),new File("./current/b4.wav"),
                            new File("./current/b5.wav"),new File("./current/b6.wav"),new File("./current/b7.wav"),new File("./current/b8.wav"),new File("./current/b9.wav"),
                            new File("./current/b10.wav"),new File("./current/b11.wav"),new File("./current/b12.wav"),new File("./current/b13.wav"),new File("./current/b14.wav"),
                            new File("./current/b15.wav"),new File("./current/b16.wav"),new File("./current/b17.wav"),new File("./current/b18.wav"),new File("./current/b19.wav"),
                            new File("./current/b20.wav"),new File("./current/b21.wav"),new File("./current/b22.wav"),new File("./current/b23.wav"),new File("./current/b24.wav"),
                            new File("./current/b25.wav"),};
    
    DataInputStream in;
    
    public Input(DataInputStream in){
        
        this.in = in;
        
    }
    
    public void run(){
        
        File note = null;
             
//        ColorMod color = new ColorMod(true, _1,  _2,  _3,  _4,  _5,  _6,  _7,  _8 ,  _9,  _10,  _11,  _12,  _13,  _14,  _15,  _16,  _17,  _18,  _19,  _20,  _21,  _22,  _23,  _24 ,  _25,  _26,  _27,  _28,  _29,  _30,  _31,  _32,  _33,  _34,  _35,  _36);
//        Thread ColorMe = new Thread(color);
//        ColorMe.start();
            
        while(true){
            
            try{
                
                String message = in.readUTF();
                
                //message printing, can avoid printing with commented statement
                //if message starting from (name length) plus 3 characters representing
                // : colon
                //   space between colon and message
                // 3 represents name length
                //is greater than 1, then print.
                //because message always starts with . it should be ok
                //if it is from server, print
                
                if ((message.startsWith("6Server")) == true){
                    
                    try{
                        
                        Thread.sleep(500);
                        
                    }catch(InterruptedException e){
                        
                    }
                    
                    System.out.println(message.substring(1));
                    PianoGUI.chatBox2.append(message.substring(1) + "\n");
                    PianoGUI.chatBox2.setCaretPosition(PianoGUI.chatBox2.getDocument().getLength());
                    continue;
                    
                }else if ((message.substring(3 + Integer.parseInt(message.substring(0,1))).startsWith(".")) == true){
                    
                    message = message.substring(0, 3 + Integer.parseInt(message.substring(0,1))) + message.substring(4 + Integer.parseInt(message.substring(0,1)));
                    PianoGUI.chatBox2.append(message.substring(1) + "\n");
                    PianoGUI.chatBox2.setCaretPosition(PianoGUI.chatBox2.getDocument().getLength());
                    continue;
                    
                }
                
                //note: for sounds to play you need folders in same directory as
                //jar file when compiled or something
                
                //clap command (/) from client to server to client
                
                if(message.endsWith("/") == true){
                    note = new File("./soundeffects/applause.wav");
                    pianoArea.append(message.substring(1) + "claps | ");
                    pianoArea.setCaretPosition(pianoArea.getDocument().getLength());
                //cricket command (\) from client to server to client
                    
                }else if(message.endsWith("\\") == true){
                    
                    note = new File("./soundeffects/cricket.wav");
                    pianoArea.append(message.substring(1) + " claps | ");
                    pianoArea.setCaretPosition(pianoArea.getDocument().getLength());
                    
                }else{

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
                        for (int j = 0; j < 61; j++){
                            if(key.equals(keyNotes[j])){
                                note = fileLocations[j];
                                pianoArea.append(message.substring(1) + " | ");
                                pianoArea.setCaretPosition(pianoArea.getDocument().getLength());
                                ColorMod color = new ColorMod(j);
                                Thread ColorMe = new Thread(color);
                                ColorMe.start();
                                break;
                            }
                        }
                    }
                }
                
                PlaySound Playsound = new PlaySound(note);
                Thread PlaySound = new Thread(Playsound);
                PlaySound.start();
                note = null;
                
            }catch (IOException e){
            }
        }
    }
}
