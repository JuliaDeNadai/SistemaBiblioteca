/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Exemplar;
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
    
    public void preencheTabelaExemplaresVazia(JTable tabela){
        dados = new DefaultTableModel();
        dados.setNumRows(0);
        dados.addColumn("Tipo");
        dados.addColumn("Título");
        dados.addColumn("Autor");
        dados.addColumn("Ano");
        dados.addColumn("Editora");
        dados.addColumn("Edição");
        dados.addColumn("Instituição");
        dados.addColumn("Departamento");
        dados.addColumn("Qntd");
                    
        tabela.setModel(dados);
    }
    
    public void preencheTabelaExemplares(JTable tabela){
        dados = new DefaultTableModel();
        dados.setNumRows(0);
        dados.addColumn("Tipo");
        dados.addColumn("Título");
        dados.addColumn("Autor");
        dados.addColumn("Ano");
        dados.addColumn("Editora");
        dados.addColumn("Edição");
        dados.addColumn("Instituição");
        dados.addColumn("Departamento");
        dados.addColumn("Qntd");
        
        //integrar com banco de dados
        for (int i =0; i<2; i++){
            dados.addRow(new Object[]{"adm", "orgulho e preconceito", "a","." , "a"});
        }            
        tabela.setModel(dados);
    }
    
    public void preencheTabelaExemplares(JTable tabela, int op){
        //tenho que fazer uma função para criar a defaultModel depois
        dados = new DefaultTableModel();
        dados.setNumRows(0);
        dados.addColumn("Tipo");
        dados.addColumn("Título");
        dados.addColumn("Autor");
        dados.addColumn("Ano");
        dados.addColumn("Editora");
        dados.addColumn("Edição");
        dados.addColumn("Instituição");
        dados.addColumn("Departamento");
        dados.addColumn("Qntd");
        
        switch(op){
            case 0:
                //integrar com banco de dados todos
                break;
            case 1:
                //integrar com banco de dados livro
                break;
            case 2:
                //integrar com banco de dados artigo
                break;
            default:
                //
        }
        
        //integrar com banco de dados
        /*for () 
            dados.addRow(new Object[]{e.getKey().getTipo(), e.getKey().getTitulo(), e.getKey().getAutor(), e.getKey().getAno(),e.getValue()});
        */            
        tabela.setModel(dados);
    }
}
