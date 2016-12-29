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
import java.util.StringTokenizer;

/**
 *
 * @author xoq5f10
 */
public class lectura {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        
        ArrayList lista = new ArrayList<String>();
        StringTokenizer mytoken;
        String line=null;
        String[] cadenas;
        String[] str= new String[7];
        int ctr=0;
        int cm=0;
        int i=0;
        
           
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
            
            
            if(!(cadenas[j].indexOf("<tr")== -1)){
                ctr++;//System.out.println(cadenas[j]+"////"+ctr+"***"+j);
            }
            
            if(ctr==3&& (cadenas[j].contains("<b>"))){
                mytoken = new StringTokenizer((cadenas[j].replaceAll("<b>","").replaceAll("</b>","")));
                while(mytoken.hasMoreTokens()){
                    str[i]=mytoken.nextToken();
                    i++;
                }
                System.out.println(str[1]+" "+str[2]);
            }
            if(ctr==4 && (cadenas[j].contains("<b>"))&&(!cadenas[j].contains("Fecha"))){
               System.out.println(cadenas[j].replaceAll("<b>","").replaceAll("</b>",""));
               cm++;
            }
            if(ctr==6 && (!cadenas[j].contains("td"))&&cadenas[j].length()!=0&&(!cadenas[j].contains("tr"))){
                System.out.println(cadenas[j]);
            }
            
            
        }
        System.out.println("/////"+cm);
    }
}
