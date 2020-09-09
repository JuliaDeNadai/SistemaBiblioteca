/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class UsuarioController {
    private String[] dadosUser = new String[12];
    private DefaultTableModel dados;
    private Usuario user;
    
    public UsuarioController(){
       
    }
    
    public void adicionaUsuario(Usuario user){
        try{
            user.inserirUsuario(user);
        }catch(Exception e){
                
        }
       
        
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
    
    public void preencheTabela(JTable table) {
        ResultSet result = null;
        dados = new DefaultTableModel(){ 
            public boolean isCellEditable(int rowIndex, int mColIndex){ 
                 return false; 
            } 
        };
         
        
        try{
            
            dados.setNumRows(0);
            dados.addColumn("ID");
            dados.addColumn("Nome");
            dados.addColumn("Tipo");
            
            /*result = user.getUsuarios();
            
            while(result.next()){
                dados.addRow(new Object[]{result.getInt(1), result.getString(2), result.getString(10)});
            }*/
            
            dados.addRow(new Object[]{"0", "joice", "Administrador"});
            dados.addRow(new Object[]{"1", "alex", "Cliente"});
            
            table.setModel(dados);
            
        }catch(Exception err){
            
        }
        
    }
    
}
