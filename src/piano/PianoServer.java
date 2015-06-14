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
        serverSocket = new ServerSocket(7777);
        System.out.println("Server started (hopefully)");
        
        //constantly check for connections
        while(true){
            //wait for client to connect
            socket = serverSocket.accept();
            
            for (int i = 0; i < 10; i++){ //max users 10
                System.out.println("Client Connected (" + socket.getInetAddress() + ") ");

                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream());

    //            out.writeUTF("This is a Java socket test.");
    //            System.out.println("Data sent");

                if (user[i] == null){
                    user[i] = new Users(out, in, user);
                    Thread thread = new Thread(user[i]);
                    thread.start();
                    break;
                }
            }
        }
        
    }
}

//should have own java file?
class Users implements Runnable{

    DataOutputStream out;
    DataInputStream in;

    Users[] user = new Users[10]; //max users 10
    String username;

    public Users(DataOutputStream out, DataInputStream in, Users[] user){
        this.out = out;
        this.in = in;
        this.user = user;
    }
    
    //when someone connects
    public void run(){
        try{
            username = in.readUTF();
            System.out.println(username + " has joined the server.");
            out.writeUTF("6Server: " + username + " has joined the server.");
        }catch(IOException e1){
            e1.printStackTrace();
        }
        while(true){
            try{
                String message = in.readUTF();
                for (int i = 0; i < 10; i++){
                    if ((user[i] != null) && (message.length() > 0) && (message != null)){
                        user[i].out.writeUTF(username.length() + username + ": " + message);
                    }                 
                }
                //if someone disconnects
            }catch (IOException e){
                this.out = null;
                this.in = null;
            }catch (Exception e2){
                this.out = null;
                this.in = null;
            }
        }

    }

}

