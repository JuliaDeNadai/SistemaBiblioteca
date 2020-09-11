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
    private int cont = 0;//??
    
    public ExemplarController(){
    }
    
    public void adicionaExemplar(Exemplar ex){
        //integrar com banco de dados   
    }
    
    public void removeExemplar(int cod){
        //integrar com banco de dados
    }
    
    public void alteraExemplar(Exemplar ex){
        //integrar com banco de dados
    }
    
    public Exemplar buscarExemplar(int cod){
        return null;
    }
    
    public void filter(JTable table, String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dados);
        table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    
    
    public void preencheTabelaExemplares(JTable tabela){
        ResultSet result = null;
        dados = new DefaultTableModel();
         
        
        try{
            
            dados.setNumRows(0);
            dados.addColumn("ID");
            dados.addColumn("Título");
            dados.addColumn("Autor");
            dados.addColumn("Tipo");
            
            /*result = user.getUsuarios();
            
            while(result.next()){
                dados.addRow(new Object[]{result.getInt(1), result.getString(2), result.getString(10), result.getString(10)});
            }*/
            tabela.setModel(dados);
            
        }catch(Exception err){
            
        }
    }
    
}
