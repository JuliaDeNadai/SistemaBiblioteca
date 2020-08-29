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
    
    public void preencheTabelaExemplares(JTable tabela, int op){
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
                //integrar com banco de dados
                break;
            case 1:
                //integrar com banco de dados
                break;
            default:
                //integrar com banco de dados
        }
        
        //integrar com banco de dados
        /*for () 
            dados.addRow(new Object[]{e.getKey().getTipo(), e.getKey().getTitulo(), e.getKey().getAutor(), e.getKey().getAno(),e.getValue()});
        */            
        tabela.setModel(dados);
    }
}
