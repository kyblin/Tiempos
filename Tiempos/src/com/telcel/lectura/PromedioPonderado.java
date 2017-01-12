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
public class PromedioPonderado {
    
    public String[] promedio(String[][] valores){
        Formato f = new Formato();
        String resultado[] = new String[4];;
        double tpe=0.0;
        double tpa=0.0;
        int turnos=0;
        
        double stpe=0.0;
        double stpa=0.0;
        int sturnos=0;
        
        double ptpe;
        double ptpa;
        
        for(String[] valor:valores){
            for(int i=1; i<valor.length; i++){
                if(i==1){
                    tpe=f.conversionDia(valor[i]);
                    
                }else if(i==2){
                    tpa=f.conversionDia(valor[i]);
                    
                }else{
                    turnos=Integer.parseInt(valor[i]);
                    stpe+=(tpe*turnos);
                    stpa+=(tpa*turnos);
                    sturnos+=turnos;
                }
            }
        }
        
        ptpe = stpe/sturnos;
        ptpa = stpa/sturnos;
        
        resultado[0]="General";
        resultado[1]=f.coversionHora(ptpe);
        resultado[2]=f.coversionHora(ptpa);
        resultado[3]=String.valueOf(sturnos);
        
        
        return resultado;
        
    }
    
    public static void main(String[] args){
        String valores[][] = new String[2][4];
        String resultado[] = new String[3];;
        valores[0][0]="Samsung";
        valores[0][1]="00:03:12";
        valores[0][2]="00:04:34";
        valores[0][3]="5";
        
        valores[1][0]="Apple";
        valores[1][1]="00:01:14";
        valores[1][2]="00:02:12";
        valores[1][3]="7";
        
        PromedioPonderado p = new PromedioPonderado();
        resultado = p.promedio(valores);
        System.out.println("tpe:"+resultado[0]+"tpa:"+resultado[1]+"turnos"+resultado[2]);
    }
    
}
