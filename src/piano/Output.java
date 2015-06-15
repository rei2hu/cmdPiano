/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Thomas
 */

public class Output implements Runnable{
    
    DataOutputStream out;
    
    public Output(DataOutputStream out){
        this.out = out;
    }
    
    public void run(){
        //Scanner scanner = new Scanner(System.in);
        while(true){
            //String message = scanner.nextLine();
//            try{
//                out.writeUTF(message);
//            }catch(IOException e){
//            }
        }
    }
  
}
