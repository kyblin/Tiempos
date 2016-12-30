/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.lectura;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


/**
 *
 * @author xoq5f10
 */
public class lectura {
        Manejador myManejador = new Manejador();;
        GUIMain myMain = new GUIMain();
        GUITiempos myTiempos = new GUITiempos();
        ArrayList lista = new ArrayList<>();
        public String path;
        
        
        
    public lectura(){
        
        myMain.jButton2.addActionListener(myManejador);
        myMain.setVisible(true);
        
        
     
    }    
    
    public void cargarArchivo()throws FileNotFoundException, IOException{
        String line;
        try (BufferedReader io = new BufferedReader(new FileReader(myMain.jTextField1.getText()))) {
            while((line = io.readLine())!=null){
                lista.add(line);
            }}
    }
        
    public static void main(String[] args) throws FileNotFoundException, IOException{
        
        
        lectura mylectura = new lectura();
        

    }

    
    
    public class Manejador implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) { 
            
            
            String nom_e=e.getActionCommand();
           if(nom_e.equals("Generar")){
               
               
               
                try {
                    cargarArchivo();
                } catch (IOException ex) {
                    Logger.getLogger(lectura.class.getName()).log(Level.SEVERE, null, ex);
                }
               
        
                String[] cadenas;

                Recortar recortar = new Recortar();

                String[][] tiempos;
                String[] marcas;
                String stt=null;
                String fecha=null;
                int ctr=0;
                int ctr2=0;
                int cm=0;
                int ct=0;
                int cm2=0;
                int i=0;
                int c=0;





                cadenas = new String[lista.size()];
                for(int k=0; k<lista.size(); k++){
                    cadenas[k]=lista.get(k).toString().trim();
                }


                for (String cadena : cadenas) {
                    if (cadena.contains("<tr")) {
                        ctr++;//System.out.println(cadenas[j]+"////"+ctr+"***"+j);
                    }
                    if (ctr==4 && (cadena.contains("<b>")) && (!cadena.contains("Fecha"))) {
                        cm++;
                    }
                }

                tiempos=new String[cm][13];
                marcas=new String[cm];

                for (String cadena : cadenas) {
                    if (cadena.contains("<tr")) {
                        ctr2++;//System.out.println(cadenas[j]+"////"+ctr+"***"+j);
                    }
                    if (ctr2==2 && (!cadena.contains("<")) && cadena.length() != 0) {
                        fecha = recortar.separarFecha(cadena);
                    }
                    if (ctr2==3 && (cadena.contains("<b>"))) {
                        stt = recortar.separarSTT(cadena.replaceAll("<b>", "").replaceAll("</b>", ""));
                    }
                    if (ctr2==4 && (cadena.contains("<b>")) && (!cadena.contains("Fecha"))) {
                        marcas[cm2] = cadena.replaceAll("<b>", "").replaceAll("</b>", "");
                        cm2++;
                    }
                    if (ctr2==6 && (!cadena.contains(">")) && cadena.length() != 0 && (!cadena.contains("/"))) {
                        if(ct==13){
                            ct=0;
                            c++;
                        }
                        tiempos[c][ct] = cadena;
                        ct++;
                    }
                }
            
                
                myTiempos.jLabel2.setText(stt);
                myTiempos.jLabel3.setText(marcas[0]);
                myTiempos.jLabel4.setText(marcas[1]);
                myTiempos.jLabel5.setText(marcas[2]);
                myTiempos.jLabel6.setText(marcas[3]);
                myTiempos.jLabel7.setText(marcas[4]);
                //myTiempos.jLabel9.setText(marcas[5]);
                
                myTiempos.jTextField1.setText(tiempos[0][8]);
                myTiempos.jTextField2.setText(tiempos[1][8]);
                myTiempos.jTextField3.setText(tiempos[2][8]);
                myTiempos.jTextField4.setText(tiempos[3][8]);
                myTiempos.jTextField5.setText(tiempos[4][8]);
                //myTiempos.jTextField6.setText(tiempos[5][8]);
                
                myTiempos.jTextField7.setText(tiempos[0][10]);
                myTiempos.jTextField8.setText(tiempos[1][10]);
                myTiempos.jTextField9.setText(tiempos[2][10]);
                myTiempos.jTextField10.setText(tiempos[3][10]);
                myTiempos.jTextField11.setText(tiempos[4][10]);
               // myTiempos.jTextField12.setText(tiempos[5][10]);
                
                myTiempos.jTextField13.setText(tiempos[0][12]);
                myTiempos.jTextField14.setText(tiempos[1][12]);
                myTiempos.jTextField15.setText(tiempos[2][12]);
                myTiempos.jTextField16.setText(tiempos[3][12]);
                myTiempos.jTextField17.setText(tiempos[4][12]);
                //myTiempos.jTextField18.setText(tiempos[5][12]);
                
                myTiempos.jLabel8.setText(fecha);
               
                
                myTiempos.setVisible(true);
                
           }
            
        }
        
    }
}
