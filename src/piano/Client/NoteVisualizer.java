/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piano.Client;

/**
 *
 * @author Thomas
 */

import java.awt.Color;
import java.lang.reflect.Field;

public class NoteVisualizer implements Runnable{
    
    int j;
    int color;
    Color colorColor;
    
    String[] colors = {"red", "orange", "blue", "pink", "green", "magenta", "cyan", "yellow", "gray", "white"};
    
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
//    public NoteVisualizer(boolean k, int j, int _1, int _2, int _3, int _4, int _5, int _6, int _7, int _8 , int _9, int _10, int _11, int _12, int _13, int _14, int _15, int _16, int _17, int _18, int _19, int _20, int _21, int _22, int _23, int _24 , int _25, int _26, int _27, int _28, int _29, int _30, int _31, int _32, int _33, int _34, int _35, int _36){
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
//    public NoteVisualizer(boolean k, int _1, int _2, int _3, int _4, int _5, int _6, int _7, int _8 , int _9, int _10, int _11, int _12, int _13, int _14, int _15, int _16, int _17, int _18, int _19, int _20, int _21, int _22, int _23, int _24 , int _25, int _26, int _27, int _28, int _29, int _30, int _31, int _32, int _33, int _34, int _35, int _36){
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
    public NoteVisualizer(int j, int color){
        this.j = j;
        this.color = color;
    }
    
    public void run(){
        try {
            Field field = Class.forName("java.awt.Color").getField(colors[color]);
            colorColor = (Color)field.get(null);
        } catch (Exception e) {
            colorColor = java.awt.Color.white;
            System.out.println("exception");
        }
        switch(j){
            case 36:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 0:
                PianoClientGUI.panel1.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel1.setBackground(Color.black);
                break;
            case 37:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 1:
                PianoClientGUI.panel2.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel2.setBackground(Color.black);
                break;
            case 2:
                PianoClientGUI.panel3.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel3.setBackground(Color.black);
                break;
            case 38:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 3:
                PianoClientGUI.panel4.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel4.setBackground(Color.black);
                break;
            case 39:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 4:
                PianoClientGUI.panel5.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel5.setBackground(Color.black);
                break;
            case 40:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 5:
                PianoClientGUI.panel6.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel6.setBackground(Color.black);
                break;
            case 6:
                PianoClientGUI.panel7.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel7.setBackground(Color.black);
                break;
            case 41:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 7:
                PianoClientGUI.panel8.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel8.setBackground(Color.black);
                break;
            case 42:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 8:
                PianoClientGUI.panel9.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel9.setBackground(Color.black);
                break;
            case 9:
                PianoClientGUI.panel10.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel10.setBackground(Color.black);
                break;
            case 43:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 10:
                PianoClientGUI.panel11.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel11.setBackground(Color.black);
                break;
            case 44:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 11:
                PianoClientGUI.panel12.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel12.setBackground(Color.black);
                break;
            case 45:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 12:
                PianoClientGUI.panel13.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel13.setBackground(Color.black);
                break;
            case 13:
                PianoClientGUI.panel14.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel14.setBackground(Color.black);
                break;
            case 46:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 14:
                PianoClientGUI.panel15.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel15.setBackground(Color.black);
                break;
            case 47:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 15:
                PianoClientGUI.panel16.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel16.setBackground(Color.black);
                break;
            case 16:
                PianoClientGUI.panel17.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel17.setBackground(Color.black);
                break;
            case 48:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 17:
                PianoClientGUI.panel18.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel18.setBackground(Color.black);
                break;
            case 49:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 18:
                PianoClientGUI.panel19.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel19.setBackground(Color.black);
                break;
            case 50:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 19:
                PianoClientGUI.panel20.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel20.setBackground(Color.black);
                break;
            case 20:
                PianoClientGUI.panel21.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel21.setBackground(Color.black);
                break;
            case 51:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 21:
                PianoClientGUI.panel22.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel22.setBackground(Color.black);
                break;
            case 52:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 22:
                PianoClientGUI.panel23.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel23.setBackground(Color.black);
                break;
            case 23:
                PianoClientGUI.panel24.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel24.setBackground(Color.black);
                break;
            case 53:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 24:
                PianoClientGUI.panel25.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel25.setBackground(Color.black);
                break;
            case 54:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 25:
                PianoClientGUI.panel26.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel26.setBackground(Color.black);
                break;
            case 55:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 26:
                PianoClientGUI.panel27.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel27.setBackground(Color.black);
                break;
            case 27:
                PianoClientGUI.panel28.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel28.setBackground(Color.black);
                break;
            case 56:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 28:
                PianoClientGUI.panel29.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel29.setBackground(Color.black);
                break;
            case 57:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 29:
                PianoClientGUI.panel30.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel30.setBackground(Color.black);
                break;
            case 30:
                PianoClientGUI.panel31.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel31.setBackground(Color.black);
                break;
            case 58:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 31:
                PianoClientGUI.panel32.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel32.setBackground(Color.black);
                break;
            case 59:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 32:
                PianoClientGUI.panel33.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel33.setBackground(Color.black);
                break;
            case 60:
                PianoClientGUI.panel37.setBackground(colorColor);
                PianoClientGUI.panel38.setBackground(colorColor);
            case 33:
                PianoClientGUI.panel34.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel34.setBackground(Color.black);
                break;
            case 34:
                PianoClientGUI.panel35.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel35.setBackground(Color.black);
                break;
            case 35:
                PianoClientGUI.panel36.setBackground(colorColor);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    
                }
                PianoClientGUI.panel36.setBackground(Color.black);
                break;

            default:
        }
        PianoClientGUI.panel37.setBackground(Color.black);
        PianoClientGUI.panel38.setBackground(Color.black);
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
