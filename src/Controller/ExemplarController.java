/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Exemplar;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 *
 * @author Edirlene
 */
public class ExemplarController {
    //private List<Exemplar> exemplares;
    
    private DefaultTableModel dados;
    Exemplar ex;
    
    public ExemplarController(){
        ex = new Exemplar();
    }
    
    public void adicionaExemplar(Exemplar ex){
        try{
            ex.inserirExemplar(ex);
        }catch(Exception e){
            System.err.println("Error..." +e);
        }
    }
    
    public void removeExemplar(String cod){
        try{
            ex.excluirExemplar(cod);
        }catch(Exception e){
            System.err.println("Error4" +e);
        }
    }
    
    public void alteraExemplar(Exemplar ex){
        //integrar com banco de dados
    }
    
    public Exemplar buscarExemplar(String cod){
        return null;
    }
    
    public void filter(JTable table, String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dados);
        table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    
    
    public void preencheTabelaExemplares(JTable tabela){
        ResultSet result = null;
        dados = new DefaultTableModel(){ 
            public boolean isCellEditable(int rowIndex, int mColIndex){ 
                return false; 
            } 
        };
         
        try{
            
            dados.setNumRows(0);
            dados.addColumn("ID");
            dados.addColumn("Título");
            dados.addColumn("Autor");
            dados.addColumn("Tipo");
            
            result = ex.getExemplares();
            while(result.next()){
                dados.addRow(new Object[]{result.getString(1), result.getString(2), result.getString(11)});
            }
            
            tabela.setModel(dados);
            
        }catch(Exception err){
            
        }
    }
    
}
