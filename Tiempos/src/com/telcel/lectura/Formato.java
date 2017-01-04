/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.lectura;

import java.util.StringTokenizer;
import java.text.DecimalFormat;


/**
 *
 * @author xoq5f10
 */
public class Formato {
    
    public double conversionDia(String tiempo){
        StringTokenizer tokens = new StringTokenizer(tiempo,":");
        int nDatos=tokens.countTokens();
        double[] datos=new double[nDatos];
        int i=0;

        while(tokens.hasMoreTokens()){
            datos[i]=Double.valueOf(tokens.nextToken()).doubleValue();
            i++;
        }
        double horas = datos[0]/24;
        double minutos= datos[1]/1440;
        double segundos= datos[2]/86400;
        double dias = horas+minutos+segundos;
        
        return dias;
        
    }
    
    
    public String coversionHora(double dias){
        
        DecimalFormat formateador = new DecimalFormat("00");
        String hora;
        
        int horas = (int)(dias*24);
        int minutos= (int)((dias*1440)%60);
        int segundos= (int)((dias*86400)%60);
        
        
        hora = formateador.format(horas)+":"+formateador.format(minutos)+":"+formateador.format(segundos);
       
        return hora;
    }
    
    
    
    public static void main(String[]args){
       
        double dia;
        Formato myFormato = new Formato();
        dia=myFormato.conversionDia("00:02:12");
        
        
        
        System.out.println(myFormato.coversionHora(dia));
    }
    
}
