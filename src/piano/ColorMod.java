/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano;

/**
 *
 * @author Thomas
 */

import java.awt.Color;

public class ColorMod implements Runnable{
    
    int j;
    
    //30 colors for gradient
    
//    Color[] colors = {new Color(0,0,44),new Color(5, 5, 60),new Color(9,9,70),new Color(12,12,80),
//                        new Color(15,15,90), new Color(18,18,100), new Color(20,20,110),new Color(26,26,120),
//                        new Color(31,31,128), new Color(36,36,138), new Color(45,45,136), new Color(51,51,149),
//                        new Color(62,62,161), new Color(72,72,171), new Color(81,81,176), new Color(91,91,185),
//                        new Color(99,99,188), new Color(110,100,192), new Color(120,120,198), new Color(131,131,202),
//                        new Color(144,144,210), new Color(155,155,212), new Color(168,168,216), new Color(180,180,222),
//                        new Color(191,191,225), new Color(201,201,228), new Color(215,215,235), new Color(234,234,240),
//                        new Color(240,240,242), new Color(255,255,255)};
//    
//    int j, _1, _2, _3, _4, _5, _6, _7, _8 ,_9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21, _22, _23, _24 ,_25, _26, _27, _28, _29, _30, _31, _32, _33, _34, _35, _36;
//    
//    int[] indexKeeper = {_1, _2, _3, _4, _5, _6, _7, _8 ,_9, _10, _11, _12, _13, _14, _15, _16, _17, _18, _19, _20, _21, _22, _23, _24 ,_25, _26, _27, _28, _29, _30, _31, _32, _33, _34, _35, _36};
//    
//    boolean k;
//    
//    public ColorMod(boolean k, int j, int _1, int _2, int _3, int _4, int _5, int _6, int _7, int _8 , int _9, int _10, int _11, int _12, int _13, int _14, int _15, int _16, int _17, int _18, int _19, int _20, int _21, int _22, int _23, int _24 , int _25, int _26, int _27, int _28, int _29, int _30, int _31, int _32, int _33, int _34, int _35, int _36){
//        this.j = j;
//        this._1 = _1;
//        this._2 = _2;
//        this._3 = _3;
//        this._4 = _4;
//        this._5 = _5;
//        this._6 = _6;
//        this._7 = _7;
//        this._8 = _8;
//        this._9 = _9;
//        this._10 = _10;
//        this._11 = _11;
//        this._12 = _12;
//        this._13 = _13;
//        this._14 = _14;
//        this._15 = _15;
//        this._16 = _16;
//        this._17 = _17;
//        this._18 = _18;
//        this._19 = _19;
//        this._20 = _20;
//        this._21 = _21;
//        this._22 = _22;
//        this._23 = _23;
//        this._24 = _24;
//        this._25 = _25;
//        this._26 = _26;
//        this._27 = _27;
//        this._28 = _28;
//        this._29 = _29;
//        this._30 = _30;
//        this._31 = _31;
//        this._32 = _32;
//        this._33 = _33;
//        this._34 = _34;
//        this._35 = _35;
//        this._36 = _36;
//        this.k = k;
//    }
//    
//    public ColorMod(boolean k, int _1, int _2, int _3, int _4, int _5, int _6, int _7, int _8 , int _9, int _10, int _11, int _12, int _13, int _14, int _15, int _16, int _17, int _18, int _19, int _20, int _21, int _22, int _23, int _24 , int _25, int _26, int _27, int _28, int _29, int _30, int _31, int _32, int _33, int _34, int _35, int _36){
//        this._1 = _1;
//        this._2 = _2;
//        this._3 = _3;
//        this._4 = _4;
//        this._5 = _5;
//        this._6 = _6;
//        this._7 = _7;
//        this._8 = _8;
//        this._9 = _9;
//        this._10 = _10;
//        this._11 = _11;
//        this._12 = _12;
//        this._13 = _13;
//        this._14 = _14;
//        this._15 = _15;
//        this._16 = _16;
//        this._17 = _17;
//        this._18 = _18;
//        this._19 = _19;
//        this._20 = _20;
//        this._21 = _21;
//        this._22 = _22;
//        this._23 = _23;
//        this._24 = _24;
//        this._25 = _25;
//        this._26 = _26;
//        this._27 = _27;
//        this._28 = _28;
//        this._29 = _29;
//        this._30 = _30;
//        this._31 = _31;
//        this._32 = _32;
//        this._33 = _33;
//        this._34 = _34;
//        this._35 = _35;
//        this._36 = _36;
//        this.k = k;
//    }
    public ColorMod(int j){
        this.j = j;
    }
    
    public void run(){
        switch(j){
            case 0:
                PianoGUI.panel1.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel1.setBackground(Color.black);
                break;
            case 1:
                PianoGUI.panel2.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel2.setBackground(Color.black);
                break;
            case 2:
                PianoGUI.panel3.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel3.setBackground(Color.black);
                break;
            case 3:
                PianoGUI.panel4.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel4.setBackground(Color.black);
                break;
            case 4:
                PianoGUI.panel5.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel5.setBackground(Color.black);
                break;
            case 5:
                PianoGUI.panel6.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel6.setBackground(Color.black);
                break;
            case 6:
                PianoGUI.panel7.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel7.setBackground(Color.black);
                break;
            case 7:
                PianoGUI.panel8.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel8.setBackground(Color.black);
                break;
            case 8:
                PianoGUI.panel9.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel9.setBackground(Color.black);
                break;
            case 9:
                PianoGUI.panel10.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel10.setBackground(Color.black);
                break;
            case 10:
                PianoGUI.panel11.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel11.setBackground(Color.black);
                break;
            case 11:
                PianoGUI.panel12.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel12.setBackground(Color.black);
                break;
            case 12:
                PianoGUI.panel13.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel13.setBackground(Color.black);
                break;
            case 13:
                PianoGUI.panel14.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel14.setBackground(Color.black);
                break;
            case 14:
                PianoGUI.panel15.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel15.setBackground(Color.black);
                break;
            case 15:
                PianoGUI.panel16.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel16.setBackground(Color.black);
                break;
            case 16:
                PianoGUI.panel17.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel17.setBackground(Color.black);
                break;
            case 17:
                PianoGUI.panel8.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel18.setBackground(Color.black);
                break;
            case 18:
                PianoGUI.panel19.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel19.setBackground(Color.black);
                break;
            case 19:
                PianoGUI.panel20.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel20.setBackground(Color.black);
                break;
            case 20:
                PianoGUI.panel21.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel21.setBackground(Color.black);
                break;
            case 21:
                PianoGUI.panel22.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel22.setBackground(Color.black);
                break;
            case 22:
                PianoGUI.panel23.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel23.setBackground(Color.black);
                break;
            case 23:
                PianoGUI.panel24.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel24.setBackground(Color.black);
                break;
            case 24:
                PianoGUI.panel25.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel25.setBackground(Color.black);
                break;
            case 25:
                PianoGUI.panel26.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel26.setBackground(Color.black);
                break;
            case 26:
                PianoGUI.panel27.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel27.setBackground(Color.black);
                break;
            case 27:
                PianoGUI.panel28.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel28.setBackground(Color.black);
                break;
            case 28:
                PianoGUI.panel29.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel29.setBackground(Color.black);
                break;
            case 29:
                PianoGUI.panel30.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel30.setBackground(Color.black);
                break;
            case 30:
                PianoGUI.panel31.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel31.setBackground(Color.black);
                break;
            case 31:
                PianoGUI.panel32.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel32.setBackground(Color.black);
                break;
            case 32:
                PianoGUI.panel33.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel33.setBackground(Color.black);
                break;
            case 33:
                PianoGUI.panel34.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel34.setBackground(Color.black);
                break;
            case 34:
                PianoGUI.panel35.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel35.setBackground(Color.black);
                break;
            case 35:
                PianoGUI.panel36.setBackground(Color.white);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoGUI.panel36.setBackground(Color.black);
                break;
            default:
        }
//        System.out.println(j);
//        System.out.println(_1);
//        while(k){
//            for (int i = 0; i < indexKeeper.length; i++){
//                if(indexKeeper[i] > 1){
//                    indexKeeper[i]--;
//                    try{
//                        Thread.sleep(5000);
//                    }catch(InterruptedException e){
//                        
//                    }
//                    System.out.println(indexKeeper[1]);
//                }
//            }
//        }
    }
}
