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
import java.awt.Color;
import java.net.*;
import java.io.*;
import java.util.*;

public class PianoClient{
    
    static Socket socket;
    static DataInputStream in;
    static DataOutputStream out;
    static String newPath;
    
    public static void main(String[] args)throws Exception{
        
        //pick ip of server
        //if cant connect, asks for new ip
        
        Scanner sc = new Scanner(System.in);
        boolean connected = false;
        while(!connected){
            System.out.print("Enter IP of server: ");
            String ip = sc.nextLine();
            System.out.println("Connecting to " + ip);
            try{
                socket = new Socket(ip, 7777);
                connected = true;
                break;
            }catch(Exception e){
                System.out.println("Cannot connect.");
                continue;
            }
        }
        
        //client sending and recieving thread
        //input thread constantly monitors what's coming in from server
        
        in = new DataInputStream(socket.getInputStream());
        Input input = new Input(in);
        Thread threadInput = new Thread(input);
        threadInput.start();
        
        //client sending and recieving thread
        //output thread constantly monitors what's being send to server
        
        out = new DataOutputStream(socket.getOutputStream());
        
        //might not need output.java anymore?
        
//        Output output = new Output(out);
//        Thread threadOutput = new Thread(output);
//        threadOutput.start();
        
        //username stuff
        //first item is username
        
        System.out.print("Enter a username: ");
        out.writeUTF("." + sc.nextLine());
        
        PianoGUI.main(args);
        while(true){
            //dunno
        }
    }
}