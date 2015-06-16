/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author Thomas
 */
public class Users implements Runnable{

    DataOutputStream out;
    DataInputStream in;
    Users[] user = new Users[10]; //max users 10
    int pid;
    
    String username;

    public Users(DataOutputStream out, DataInputStream in, Users[] user, int pid){
        this.out = out;
        this.in = in;
        this.user = user;
        this.pid = pid;
    }
    
    //when someone connects
    public void run(){
        try{
            
            //first string recieved is the username
            
            username = in.readUTF().substring(1);
            System.out.println(username + " has joined the server.");
            for (int i = 0; i < 10; i++){
                    if (user[i] != null){
                        try{
                            user[i].out.writeUTF("6Server: " + username + " has joined the server.");
                        }catch(IOException e2){
                            
                        }
                    }                 
                }
        }catch(IOException e){
            e.printStackTrace();
        }
        
        while(true){
            try{
                
                //chat messages and notes
                
                String message = in.readUTF();
                
                if (message.startsWith("MESSG")){
                            System.out.println(username.length() + username + ": " + message);
                }
                
                for (int i = 0; i < 10; i++){
                    if ((user[i] != null) && (message.startsWith("NOTE"))){
                        user[i].out.writeUTF(message);
                        user[i].out.writeUTF("COLOR" + pid);
                        
                    }else if ((user[i] != null) && (message.startsWith("MESSG"))){
                        user[i].out.writeUTF(username.length() + username + ": " + message);
                    }
                }
                
                //if someone disconnects
                
            }catch (IOException e){
                PianoServer.user[pid] = null;
                for (int i = 0; i < 10; i++){
                    if (user[i] != null){
                        try{
                            user[i].out.writeUTF("6Server: " + username + " has left the server.");
                        }catch(IOException e2){
                            
                        }
                    }                 
                }
                System.out.println(username + " has disconnected. IO");
                break;
            }catch (Exception e){
                PianoServer.user[pid] = null;
                for (int i = 0; i < 10; i++){
                    if (user[i] != null){
                        try{
                            user[i].out.writeUTF("6Server: " + username + " has left the server.");
                        }catch(IOException e2){
                            
                        }
                    }                 
                }
                System.out.println(username + " has disconnected. E");
                break;
            }
        }
    }
}