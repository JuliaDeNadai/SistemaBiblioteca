/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Usuario;
import java.util.*;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class UsuarioController {
    private String[] dadosUser = new String[12];
    private DefaultTableModel dados;
    
    public UsuarioController(){
       
    }
    
    public void adicionaUsuario(Usuario user){
        //integrar com banco de dados
        
    }
    
    public void alteraUsuario(Usuario user){
        //integrar com banco de dados
    }
    
    public void removeUsuario(int cod){
        //integrar com banco de dados
    }
    
    public void removeUsuario(int cod[]){
        //integrar com banco de dados
    }
    
    public Usuario buscarUsuario(int cod){
        Usuario user ;
        return null;
    }
    
    public Boolean realizaLogin(String user, String passwrd){
        //banco de dados
        return null;
    }
    
    // Implementação da parte de pesquisa
    public void filter(JTable table, String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dados);
        table.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }
    
    public void preencheTabela(JTable table){
       
    }
    
    public void preencheTabela(JTable table, String cod){
        dados = new DefaultTableModel();
        
        // o table model vai depender da classificação: todos, cliente ou adms
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
       
    }
    
    public void preencheTabela(JTable table, int op){
        switch(op){
            case 0:
                //integrar com banco de dados todos
                break;
            case 1:
                //integrar com banco de dados cliente
                break;
            default:
                //integrar com banco de dados adm
        }
    }
}
