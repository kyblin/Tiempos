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
        
        
        
    public lectura(){
        
        myMain.jButton2.addActionListener(myManejador);
        myMain.setVisible(true);
        
        
     
    }    
    
    public void cargarArchivo()throws FileNotFoundException, IOException{
        String line;
        try (BufferedReader io = new BufferedReader(new FileReader(myMain.jTextField1.getText()))) {
            lista.clear();
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
                
                Formato formato = new Formato();
                PromedioPonderado p = new PromedioPonderado();

                String[][] tiempos;
                String[][] general=new String[1][4];
                String[][] total;
                String stt=null;
                String fecha=null;
                String[] promediop;
                int ctr=0;
                int ctr2=0;
                int cm=0;
                int ct=0;
                int cm2=0;
                int c=0;
                int i=1;
                int j=0;





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

                tiempos=new String[cm][4];


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
                        tiempos[cm2][0] = cadena.replaceAll("<b>", "").replaceAll("</b>", "");
                        cm2++;
                    }
                    if (ctr2==6 && (!cadena.contains(">")) && cadena.length() != 0 && (!cadena.contains("/"))) {
                        if(ct==13){
                            ct=0;
                            i=1;
                            c++;
                        }
                        if(ct==8||ct==10||ct==12){
                            if(!cadena.contains(".")){
                                tiempos[c][i] = cadena;
                                
                            }else{
                                tiempos[c][i] = formato.coversionHora(Double.parseDouble(cadena));
                            }

                            i++;
                        }
                        ct++;
                    }
                }
                
                promediop=p.promedio(tiempos);
                
                total = new String[cm+1][4];
                
                for(int w=0; w<tiempos.length; w++){
                    for(int z=0; z<tiempos[w].length; z++){
                        total[w][z]=tiempos[w][z];
                    }
                }
                
                for(String promedio:promediop){
                    total[cm][j]=promedio;
                    j++;
                }
                
                
                            
                myTiempos.jLabel2.setText(stt);
                myTiempos.jLabel4.setText(fecha);
                
                myTiempos.jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    total,
                    new String [] {
                        "Marca", "TPE", "TPA", "Clientes"
                    }
                ) {
                    boolean[] canEdit = new boolean [] {
                        false, false, false, false
                    };

                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                    }
                });
                
                myTiempos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                myTiempos.setVisible(true);
                
           }
            
        }
        
    }
}
