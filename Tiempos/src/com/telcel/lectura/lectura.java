/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.lectura;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author xoq5f10
 */
public class lectura {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        
        ArrayList lista = new ArrayList<String>();
        String line=null;
        String[] cadenas;
        int cb=0;
        int ctr=0;
        int co=0;
        int cm=0;
        
           
        BufferedReader io = new BufferedReader(new FileReader("C:\\Users\\xoq5f10\\Desktop\\test.xls"));
       
      
       while((line = io.readLine())!=null){
        lista.add(line);
       }
        io.close();
                
        cadenas = new String[lista.size()];
        for(int k=0; k<lista.size(); k++){
            cadenas[k]=lista.get(k).toString().trim();
        }
        
        
        for (int j=0; j<cadenas.length; j++) {
            
            
            if(!(cadenas[j].indexOf("<tr>")== -1)){
                ctr++;//System.out.println(cadenas[j]+"////"+ctr+"***"+j);
            }
            else if(!(cadenas[j].indexOf("<b>")== -1)){
                cb++;//System.out.println(cadenas[j]+"////"+cb+"***"+j);
            }
            else {co++;//System.out.println(cadenas[j]+"////"+co+"***"+j);
            }
            if(j==25||j==36){
                System.out.println(cadenas[j]);
            }
            if(ctr==4 && (cadenas[j].contains("<b>"))&&(!cadenas[j].contains("Fecha"))){
                System.out.println(cadenas[j]);
                cm++;
            }
            
            
        }
        System.out.println("/////"+cm);
    }
}
