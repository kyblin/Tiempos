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
import javax.swing.JScrollPane;

/**
 *
 * @author hectorcavadavaldez
 */
public class Table extends JTable{
    int fila=0;
    Font fuente=new Font("Tahoma",Font.BOLD, 11);
    Color grisClaro= new Color(192,192,192);
    JScrollPane jScrollPane1 = new JScrollPane();
    
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
        
        if(isCellSelected(rowIndex,columnIndex)){
            component.setBackground(new Color(51,153,255));
            component.setForeground(Color.ORANGE);
        }
        
        if (this.getColumnModel().getColumnCount() > 0) {
            this.getColumnModel().getColumn(0).setResizable(false);
            this.getColumnModel().getColumn(1).setResizable(false);
            this.getColumnModel().getColumn(2).setResizable(false);
            this.getColumnModel().getColumn(3).setResizable(false);
        }
        
        this.getTableHeader().setReorderingAllowed(false);
       
        
        return component;
        
    }
        
}
