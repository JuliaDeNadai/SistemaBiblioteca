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
    private String[] dadosExemplar = new String[8];
    private DefaultTableModel dados;
    private Exemplar ex;
    
    public ExemplarController(){
        //dadosExemplar ;
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
    
    public void alteraExemplar(Exemplar ex, String cod){
        try{
            ex.alterarExemplar(ex, cod);
        }catch(Exception e){
            System.err.println("Error13..." +e);
        }
    }
    
    public Exemplar buscarExemplar(String cod){
        Exemplar e = new Exemplar();
        
        try{
            e = ex.searchExemplarByID(cod);       
        }catch(Exception err){
            System.err.println("Error7" +err);
        }
        return e;
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
                dados.addRow(new Object[]{result.getString(1), result.getString(3), result.getString(4), result.getString(6)});
            }
            tabela.setModel(dados);
            
        }catch(Exception err){
            
        }
    }
    
}
