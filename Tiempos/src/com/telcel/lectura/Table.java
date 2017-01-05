/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.telcel.lectura;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author hectorcavadavaldez
 */
public class Table extends JTable{
    int fila=0;
    Font fuente=new Font("",Font.BOLD, 12);
    Color grisClaro= new Color(192,192,192);
    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int rowIndex, int columnIndex){
        Component component = super.prepareRenderer(renderer, rowIndex, columnIndex);
        component.setBackground(Color.WHITE);
        component.setForeground(Color.BLACK);
        String valor=this.getValueAt(rowIndex, columnIndex).toString();
        
        if(rowIndex%2 == 0){
            component.setBackground(grisClaro);
        }

        if(valor.equals("General")){
            fila=rowIndex;
        }    
        
        if(fila==rowIndex){
            component.setBackground(Color.GRAY);
            component.setForeground(Color.WHITE);
            component.setFont(fuente);
        }
        
        return component;
        
    }
    
}
