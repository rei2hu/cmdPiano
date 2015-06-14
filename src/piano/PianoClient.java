/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;
/**
 *
 * @author Thomas
Running:

@echo off

echo Server or client (s/c)?

set /p var=
if '%var%' == 's' goto Server
if '%var%' == 'c' goto Client

echo that's not a choice
pause
exit

:Server
java -cp Piano(noip).jar piano.PianoServer

:Client
java -cp Piano(noip).jar piano.PianoClient
 */
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class PianoClient{
    
    static Socket socket;
    static DataInputStream in;
    static DataOutputStream out;
    static String newPath;
    
    public static void main(String[] args)throws Exception{
        
        //pick ip of server
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter IP of server: ");
        String ip = sc.nextLine();
        System.out.println("Connecting to " + ip);
        socket = new Socket(ip, 7777);
        System.out.println("Connected");
        
        //client sending and recieving thread
        
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        Input input = new Input(in);
        Thread thread = new Thread(input);
        thread.start();
        
        //username stuff
        //first item is username
        
        System.out.print("Enter a username: ");
        String username = sc.nextLine();
        out.writeUTF(username);
        
        Robot robot = new Robot();
//        BufferedReader typed = new BufferedReader(new InputStreamReader(System.in));
//        String line = "";
        boolean wait = false;
        while(true){
            
            //force enter key press because cant figure out keyevent/listener stuff and don't want gui
            
            if(!wait){
                robot.keyPress(KeyEvent.VK_ENTER);
            }
            
            String sendMessage = sc.nextLine();
            wait = false;

            //chat commands applaud and crickets
            //applause = //
            //crickets = \\
            //wait so doing these commands wont interfere with chat
            
            if ((sendMessage.endsWith("//") == true) || (sendMessage.endsWith("\\\\") == true)){
                wait = true;
            }
            
            //chatting and other commands
            //
            //chat messages start with .
            //change directory --- .dir/
            //
            //chat messages and commands apart from applause and crickets start with period
            //wait so doing these commands wont interfere with chat
            
            if ((sendMessage.startsWith(".") == true)){
                sendMessage = sendMessage.substring(1);
//                if (Pattern.matches("dir/(.*)", sendMessage) == true){
//                    String newPath = sendMessage.substring(4);
//                    System.out.println("New piano sound directory set" + newPath);
//                }
                wait = true;
            }
            out.writeUTF(sendMessage);
        }
    }
}

class Input implements Runnable{
    
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
                //possible that 2 keys are pressed fast enough when playing so they are sent
                
                if ((message.length() - Integer.parseInt(message.substring(0, 1)) - 3) > 1){
                    System.out.println(message.substring(1));
                    continue;
                }
                
                
//                if(message.startsWith("6Server:") == true ){
//                    continue;
//                }else 
                
                
                //note: for sounds to play you need folders in same directory as
                //jar file when compiled or something
                
                //clap command (//) from client to server to client
                
                if(message.endsWith("//") == true){
                    note = new File("./soundeffects/applause.wav");
                    PlaySound(note);
                    continue;
                    
                //cricket command (\\) from client to server to client
                    
                }else if(message.endsWith("\\\\") == true){
                    note = new File("./soundeffects/cricket.wav");
                    PlaySound(note);
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
                
                for (int i = Integer.parseInt(message.substring(0, 1)) + 3; i < message.length(); i++){
                    String key = Character.toString(message.charAt(i));
                    switch(key){
                        case "1":
                                note = new File("./maestro/a1.wav");
                                break;
                        case "2":
                                note = new File("./maestro/a2.wav");
                                break;
                        case "3":
                                note = new File("./maestro/a3.wav");
                                break;
                        case "4":
                                note = new File("./maestro/a4.wav");
                                break;
                        case "5":
                                note = new File("./maestro/a5.wav");
                                break;
                        case "6":
                                note = new File("./maestro/a6.wav");
                                break;
                        case "7":
                                note = new File("./maestro/a7.wav");
                                break;
                        case "8":
                                note = new File("./maestro/a8.wav");
                                break;
                        case "9":
                                note = new File("./maestro/a9.wav");
                                break;
                        case "0":
                                note = new File("./maestro/a10.wav");
                                break;
                        case "q":
                                note = new File("./maestro/a11.wav");
                                break;
                        case "w":
                                note = new File("./maestro/a12.wav");
                                break;
                        case "e":
                                note = new File("./maestro/a13.wav");
                                break;
                        case "r":
                                note = new File("./maestro/a14.wav");
                                break;
                        case "t":
                                note = new File("./maestro/a15.wav");
                                break;
                        case "y":
                                note = new File("./maestro/a16.wav");
                                break;
                        case "u":
                                note = new File("./maestro/a17.wav");
                                break;
                        case "i":
                                note = new File("./maestro/a18.wav");
                                break;
                        case "o":
                                note = new File("./maestro/a19.wav");
                                break;
                        case "p":
                                note = new File("./maestro/a20.wav");
                                break;
                        case "a":
                                note = new File("./maestro/a21.wav");
                                break;
                        case "s":
                                note = new File("./maestro/a22.wav");
                                break;
                        case "d":
                                note = new File("./maestro/a23.wav");
                                break;
                        case "f":
                                note = new File("./maestro/a24.wav");
                                break;
                        case "g":
                                note = new File("./maestro/a25.wav");
                                break;
                        case "h":
                                note = new File("./maestro/a26.wav");
                                break;
                        case "j":
                                note = new File("./maestro/a27.wav");
                                break;
                        case "k":
                                note = new File("./maestro/a28.wav");
                                break;
                        case "l":
                                note = new File("./maestro/a29.wav");
                                break;
                        case "z":
                                note = new File("./maestro/a30.wav");
                                break;
                        case "x":
                                note = new File("./maestro/a31.wav");
                                break;
                        case "c":
                                note = new File("./maestro/a32.wav");
                                break;
                        case "v":
                                note = new File("./maestro/a33.wav");
                                break;
                        case "b":
                                note = new File("./maestro/a34.wav");
                                break;
                        case "n":
                                note = new File("./maestro/a35.wav");
                                break;
                        case "m":
                                note = new File("./maestro/a36.wav");
                                break;
                        case "!":
                                note = new File("./maestro/b1.wav");
                                break;
                        case "@":
                                note = new File("./maestro/b2.wav");
                                break;
                        case "$":
                                note = new File("./maestro/b3.wav");
                                break;
                        case "%":
                                note = new File("./maestro/b4.wav");
                                break;
                        case "^":
                                note = new File("./maestro/b5.wav");
                                break;
                        case "*":
                                note = new File("./maestro/b6.wav");
                                break;
                        case "(":
                                note = new File("./maestro/b7.wav");
                                break;
                        case "Q":
                                note = new File("./maestro/b8.wav");
                                break;
                        case "W":
                                note = new File("./maestro/b9.wav");
                                break;
                        case "E":
                                note = new File("./maestro/b10.wav");
                                break;
                        case "T":
                                note = new File("./maestro/b11.wav");
                                break;
                        case "Y":
                                note = new File("./maestro/b12.wav");
                                break;
                        case "I":
                                note = new File("./maestro/b13.wav");
                                break;
                        case "O":
                                note = new File("./maestro/b14.wav");
                                break;
                        case "P":
                                note = new File("./maestro/b15.wav");
                                break;
                        case "S":
                                note = new File("./maestro/b16.wav");
                                break;
                        case "D":
                                note = new File("./maestro/b17.wav");
                                break;
                        case "G":
                                note = new File("./maestro/b18.wav");
                                break;
                        case "H":
                                note = new File("./maestro/b19.wav");
                                break;
                        case "J":
                                note = new File("./maestro/b20.wav");
                                break;
                        case "L":
                                note = new File("./maestro/b21.wav");
                                break;
                        case "Z":
                                note = new File("./maestro/b22.wav");
                                break;
                            
                        case "C":
                                note = new File("./maestro/b23.wav");
                                break;
                        case "V":
                                note = new File("./maestro/b24.wav");
                                break;
                        case "B":
                                note = new File("./maestro/b25.wav");
                                break;
//                        case "/":  
//                                PlaySound(getClass().getResourceAsStream("/soundeffects/applause.wav"));
//                                
//                                break;
                        default:
//                            System.out.println("nothing");
                                continue;
                    }
                    PlaySound(note);
                }
//                System.out.println(message);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    //wav playing
    
    public static void PlaySound(File Sound){
        try
        {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Sound));
            clip.start();
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }
}