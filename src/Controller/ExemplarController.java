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
    private HashMap<Exemplar, Integer> exemplares;
    private DefaultTableModel dados;
    private int cont = 0;
    
    public ExemplarController(){
	exemplares = new HashMap<Exemplar, Integer>();
    }
    
    private void adicionaExemplar(Exemplar ex){
        if(!exemplares.containsKey(ex.getTitulo())){   
            exemplares.put(ex,1);
        }else{
            Integer a = exemplares.get(ex.getTitulo());
            exemplares.put(ex, (a+1));
        }        
    }
    
    private void removeExemplar(Exemplar ex){}
    
    private HashMap<Exemplar, Integer> getExemplares(){
        return exemplares;
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
        
        for (Map.Entry<Exemplar, Integer> e : exemplares.entrySet()) 
            dados.addRow(new Object[]{e.getKey().getTipo(), e.getKey().getTitulo(), e.getKey().getAutor(), e.getKey().getAno(),e.getValue()});
                    
        tabela.setModel(dados);
    }
}
