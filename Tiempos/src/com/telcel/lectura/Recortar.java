/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.lectura;

/**
 *
 * @author xoq5f10
 */
public class Recortar {
    
    String separarSTT(String texto){
        
        String texto2;
        int pos1;
        int pos2;
        
        pos1 = texto.indexOf(":");
        pos2 = texto.indexOf("(");
        
        if(pos1 != -1 && pos2 != -1){
            texto2 = texto.substring(pos1+1, pos2).trim();
        }else{texto2 = "STT Telcel";}
        
        
        return texto2;
    }
    
    String separarFecha(String texto){
        String texto2;
        int pos;
        
        pos=texto.indexOf(" ");
        
        if(pos != -1){
            texto2 = texto.substring(0, pos).trim();
        }else{texto2 = "No Fecha";}
        
        return texto2;
    }
    
}
