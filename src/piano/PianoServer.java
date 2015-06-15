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

public class PianoServer {

    static ServerSocket serverSocket;
    static Socket socket;
    static DataOutputStream out;
    static Users[] user = new Users[10]; //max users 10
    static DataInputStream in;
    
    public static void main(String[] args)throws Exception{
        
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
            //wait for client to connect
            socket = serverSocket.accept();
            
            System.out.println("Client Connected (" + socket.getInetAddress() + ") ");
            
            for (int i = 0; i < 10; i++){ //max users 10

                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream());

    //            out.writeUTF("This is a Java socket test.");
    //            System.out.println("Data sent");

                if (user[i] == null){
                    user[i] = new Users(out, in, user, i);
                    Thread thread = new Thread(user[i]);
                    thread.start();
                    break;
                }
            }
        }
        
    }
}

