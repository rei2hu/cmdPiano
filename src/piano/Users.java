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
    String username;

    public Users(DataOutputStream out, DataInputStream in, Users[] user){
        this.out = out;
        this.in = in;
        this.user = user;
    }
    
    //when someone connects
    public void run(){
        try{
            
            //first string recieved is the username
            
            username = in.readUTF().substring(1);
            System.out.println(username + " has joined the server.");
            out.writeUTF("6Server: " + username + " has joined the server.");
        }catch(IOException e1){
            e1.printStackTrace();
        }
        
        while(true){
            try{
                
                //chat messages and notes
                
                String message = in.readUTF();
                for (int i = 0; i < 10; i++){
                    if ((user[i] != null) && (message.length() > 0) && (message != null)){
                        if (message.length() > 1){
                            System.out.println(username.length() + username + ": " + message);
                        }
                        user[i].out.writeUTF(username.length() + username + ": " + message);
                    }                 
                }
                
                //if someone disconnects
                
            }catch (IOException e){
                this.out = null;
                this.in = null;
                continue;
            }catch (Exception e2){
                this.out = null;
                this.in = null;
                continue;
            }
        }

    }

}