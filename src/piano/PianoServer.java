/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;

/**
 *
 * @author Thomas
 * Main reference(s): https://www.youtube.com/watch?v=1a3TtPr_yvI
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

import java.io.*;
import java.net.*;
import java.util.Random;

public class PianoServer {

    static ServerSocket serverSocket;
    static Socket socket;
    static DataOutputStream out;
    static Users[] user = new Users[10]; //max users 10
    static DataInputStream in;
    
    public static void main(String[] args)throws Exception{
        
        Random rand = new Random();
        //get ip
        URL myip = new URL("http://checkip.amazonaws.com");
        BufferedReader inBR = new BufferedReader(new InputStreamReader(
        myip.openStream()));
        String ip = inBR.readLine();
        
        //start server
        System.out.println("Starting server on " + ip + ":7777");
        try{
            serverSocket = new ServerSocket(7777);
        }catch(IOException e){
            System.out.println("Could not start server!");
            System.in.read();
            System.exit(0);
        }
        System.out.println("Server started!");
        
        
        //constantly check for connections
        while(true){
            boolean allowConnect = true;
            //wait for client to connect
            socket = serverSocket.accept();
            
            System.out.println("Client Connected (" + socket.getInetAddress() + ") ");
            
            //check ip ban list
            try (BufferedReader br = new BufferedReader(new FileReader("ipban.txt"))) {
                String line;
                while ((line = br.readLine()) != null) {
                   if(socket.getInetAddress().toString().equals(line)){
                       System.out.println("This ip is banned!");
                       allowConnect = false;
                   }
                }
            }
            
            if(allowConnect){
                
                while(true){
                    
                    //PROBABLY NOT BEST WAY TO DO IT
                    int i = rand.nextInt(10);
                    System.out.println(i);
                    
                    if (user[i] == null){
                        out = new DataOutputStream(socket.getOutputStream());
                        in = new DataInputStream(socket.getInputStream());
                        user[i] = new Users(out, in, user, i);
                        Thread thread = new Thread(user[i]);
                        thread.start();
                        break;
                    }
                }
            }
        }
    }
}

